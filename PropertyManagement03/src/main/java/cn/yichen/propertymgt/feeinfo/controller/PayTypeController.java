package cn.yichen.propertymgt.feeinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.feeinfo.model.PayType;
import cn.yichen.propertymgt.utils.BaseController;

/**
 * 
 * @date 2019年8月27日 下午3:03:58
 * @author YiChen(李冠永)
 * @Description 付款类型控制层实现
 *
 */
@RestController
@RequestMapping("/paytype")
public class PayTypeController extends BaseController<PayType> {

}
