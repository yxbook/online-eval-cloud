package com.eval.common.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: youxun
 * @Version: 1.0
 **/
public class BaseController<T,K extends IService<T>> implements BaseApiService<T>{

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected K service;

    @Override
    public BaseResult insert(@RequestBody T entity) {
        return new BaseResult(BaseResultEnum.SUCCESS.getStatus(), "添加成功", service.insert(entity));
    }

    @Override
    public BaseResult deleteById(String id) {
        try {
            int idx = Integer.parseInt(id);
            if (service.deleteById(idx))return new BaseResult(BaseResultEnum.SUCCESS,"数据删除成功");
            else return new BaseResult(BaseResultEnum.ERROR,"删除失败");
        }catch (NumberFormatException e){
            if (service.deleteById(id))return new BaseResult(BaseResultEnum.SUCCESS,"数据删除成功");
            else return new BaseResult(BaseResultEnum.ERROR,"删除失败");
        }
    }

    @Override
    public BaseResult updateById(@RequestBody T entity) {
        if (service.updateById(entity))return new BaseResult(BaseResultEnum.SUCCESS.getStatus(), "修改成功","数据修改成功");
        else return new BaseResult(BaseResultEnum.ERROR,"修改失败");
    }

    @Override
    public BaseResult<T> selectById(String id) {
        return new BaseResult(BaseResultEnum.SUCCESS,service.selectById(id));
    }


    @Override
    public BaseResult<List<T>> selectAll(@RequestParam Map<String, Object> params) {
        Query query = new Query<T>(params);
        try {
            return new BaseResult(BaseResultEnum.SUCCESS,service.selectList(query.getEntityWrapper()));
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResult(BaseResultEnum.ERROR,"请检查参数是否正确");
        }
    }

    @Override
    public BaseResult<Page<T>> selectPage(@RequestParam Map<String, Object> params) {
        Query query = new Query<T>(params);
        try {
            Page<T> tPage =new Page<>(query.getPageNo(),query.getPageSize());
            tPage.setSearchCount(true);
            return new BaseResult(BaseResultEnum.SUCCESS,service.selectPage(tPage,query.getEntityWrapper()));
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResult(BaseResultEnum.ERROR,"请检查参数是否正确");
        }
    }


    /**
     * 统一异常处理
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        LOGGER.error("统一异常处理：", exception);
        request.setAttribute("ex", exception);
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            request.setAttribute("requestHeader", "ajax");
        }
        return new BaseResult(BaseResultEnum.ERROR.getStatus(),"请求错误！", exception.getMessage());
    }


    /**
         * 查询参数
         */
    public class Query<T> extends LinkedHashMap<String, Object> {
        private static final long serialVersionUID = 1L;
        //当前页码
        private int pageNo = 1;
        //每页条数
        private int pageSize = 20;

        private EntityWrapper<T> entityWrapper = new EntityWrapper<>();

        public Query(Map<String, Object> params){
            if (null != params){
                this.putAll(params);
                //分页参数
                if(params.get("pageNo")!=null) {
                    this.pageNo = Integer.parseInt(params.get("pageNo").toString());
                }
                if(params.get("pageSize")!=null) {
                    this.pageSize = Integer.parseInt(params.get("pageSize").toString());
                }
                // 降序字段
                if(params.get("orderBy")!=null) {
                    entityWrapper.orderBy(params.get("orderBy").toString(),false);
                }
                // 升序字段
                if(params.get("orderByAsc")!=null) {
                    entityWrapper.orderBy(params.get("orderByAsc").toString(),true);
                }
                this.remove("pageNo");
                this.remove("pageSize");
                this.remove("orderBy");
                this.remove("orderByAsc");
                this.forEach((k,v) ->{
                    if (k.startsWith("_")){
                        entityWrapper.like(k.substring(1,k.length()), v.toString());
                    }else {
                        entityWrapper.eq(k, v);
                    }
                });
            }
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public EntityWrapper<T> getEntityWrapper() {
            return entityWrapper;
        }

        public void setEntityWrapper(EntityWrapper<T> entityWrapper) {
            this.entityWrapper = entityWrapper;
        }
    }

}
