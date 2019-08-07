package cn.yichen.bootwebmybatis.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.yichen.bootwebmybatis.security.model.UserModel;
import cn.yichen.bootwebmybatis.security.service.IUserService;


@RestController
@RequestMapping("/user")
// @SessionAttributes(name) // 当控制器有任意方法有保存name属性时,自动将其加到session域中
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/get/{id}")
	@ResponseBody // 设置响应类型为json(默认),将返回结果直接发送到客户端,
	// @RequestBody // 参数是来自请求体的json,可用于参数前面
	// @RequestHeader // 参数是来自请求头,用于参数前面
	// @PathVariable // 参数是来自于请求地址的,如@RequestMapping("user/get/{id}")
	// @CookieValue // 参数是来自Cookie的值
	// @ModelAttribute // 用于参数前面,默认取得(优先)Model中指定的属性,若为null,使用封装机制获取封装
	// @ModelAttribute // 用于方法前面,不能设置@RequestMapping,用于给Model设置属性,值为方法返回值,任何请求前自动调用
	// @SessionAttribute //取得指定的Session属性值,用于参数前面
	// @RequestAttribute //取得指定的Request属性值,用于参数前面
	public UserModel get(@PathVariable String id, @RequestBody(required = false) UserModel model) throws Exception {
		System.out.println(model);
		return service.getUserById(id);
	}

	@RequestMapping(value = { "list" }, method = { RequestMethod.GET, RequestMethod.POST } // 设置请求方法
	// consumes = {"application/json", "!application/js"} // 设置请求类型MIME协议,
	// produces = {"application/json"} // 设置响应类型,响应json数据,需要使用@ResponseBody
	// params = {} // 设置请求参数(请求参数必须,否则不处理)
	// headers = {} // 设置请求头(请求头必须包含,否则不处理)
	)
	public List<UserModel> list(Model model) throws Exception {

		List<UserModel> users = null;
		try {
			users = service.getListByAll(null);
			model.addAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	// 处理该类所有异常
	@ExceptionHandler // 异常处理
	public ResponseEntity<String> handler(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// ResponseEntity<T> // 标识整个http响应：状态码、头部信息、响应体内容(spring)
	// @ResponseBody // 加在请求处理方法上，能够处理方法结果值作为http响应体（springmvc）
	// @ResponseStatus // 加在方法上、返回自定义http状态码(spring)
	@RequestMapping("download")
	public ResponseEntity<InputStreamResource> download(@RequestParam(required = true) String filename,
			HttpSession session) throws Exception {

		// 获得服务器路径
		String path = session.getServletContext().getRealPath("/WEB-INF/upload/");
		// 获得完整的路径
		String realPath = path + filename;

		// 设置下载资源
		InputStreamResource resource = new InputStreamResource(new FileInputStream(realPath));

		// 设置头信息
		HttpHeaders headers = new HttpHeaders();
		// 设置下载的附件
		headers.setContentDispositionFormData("attachment", filename);
		// 设置MIME类型
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
	}

	@RequestMapping("upload")
	@ResponseBody
	public String upload(UserModel userModel, @RequestParam(required = false) MultipartFile photo, HttpSession session)
			throws Exception {

		if (photo == null || photo.isEmpty()) {
			System.out.println("无图片");
		} else {
			// 获取文件名
			String filename = photo.getOriginalFilename();
			// 处理中文编码
			// filename= new String(filename.getBytes("utf-8"), "iso-8859-1");
			// 获取文件类型
			String contentType = photo.getContentType();
			// 获得服务器路径
			String path = session.getServletContext().getRealPath("/WEB-INF/upload/");
			// 获得完整的路径
			String realPath = path + filename;
			// 把文件保存到指定目录
			File dir = new File(path);
			if (!dir.exists()) dir.mkdirs();
			photo.transferTo(new File(realPath));
		}

		return "OK";
	}
}
