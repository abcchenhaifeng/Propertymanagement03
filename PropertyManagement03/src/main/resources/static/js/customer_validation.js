/**
 * 自定义的验证规则
 */
//验证邮政编码
$.validator.addMethod("zipcode", function(value,element,params){
   var zippattern = /^[0-9]{6}$/; 
   return this.optional(element)||zippattern.test(value);
	
} ,"非法的邮政编码");

//验证手机号码
$.validator.addMethod("mobile", function(value,element,params){
	var mobilepattern = /^1[3456789]\d{9}$/;
	
	return this.optional(element)||mobilepattern.test(value);
	
		
	} ,"非法的手机号码");


// 匹配integer
$.validator.addMethod("isInteger", function(value, element) {       
     return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value)>=0);       
}, "请输入整数值");  






//验证身份证号码
$.validator.addMethod("card", function(value,element,params){
	var cardpattern = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
	
	return this.optional(element)||cardpattern.test(value);
	
		
	} ,"非法的身份证号码");
