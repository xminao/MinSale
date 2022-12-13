package pers.minho.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;
import pers.minho.util.UUIDUtil;
import pers.minho.util.UserUtil;

//@WebServlet("/GoodsServlet")
public class PutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		HttpSession ses = request.getSession();
		request.setCharacterEncoding("UTF-8");
		GoodsService g_service = new GoodsService();
		
		try {
			if (UserUtil.isLogined(request)) {
				System.out.println("PutServlet");
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				String uploadPath = "D:\\Courses_fall_22\\IT_Training\\workspace\\web\\goods_imgs";
				//String uploadPath = "D:\\Courses_fall_22\\IT_Training\\workspace\\MinSell\\WebContent\\static\\goods_imgs";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				
				User user = (User)ses.getAttribute("loginUser");
				Goods goods = new Goods();
				
				List<FileItem> formItems = upload.parseRequest(request);
				if (formItems != null && formItems.size() > 0) {
	                // 迭代表单数据，判断每个表单项是普通类型还是上传的文件
	                for (FileItem item : formItems) {
	                    //上传的数据为文件的表单项处理方式
	                    if (!item.isFormField()) {
	                        //文件名
	                        String fileName = item.getName();
	                        String suffix = fileName.substring(fileName.lastIndexOf("."));
	                        System.out.println("文件名："+fileName);
	                        // 保存的路径
	                        String UUIDName = UUIDUtil.getUUID() + suffix;
	                        String filePath = uploadPath + File.separator + UUIDName;
	                        System.out.println(filePath);
	                        // 保存文件到硬盘
	                        File storeFile = new File(filePath);
	                        goods.setImg("/static/goods_imgs/" + UUIDName);
	                        item.write(storeFile);
	                        request.setAttribute("message", "文件上传成功!");
	                    } else {
	                    	String filedName = item.getFieldName();
	                    	String value = item.getString("UTF-8");
	                    	
	                    	System.out.println(value);
	                    	
	                    	if (filedName.equals("selectType")) {
	                    		int selectType = Integer.parseInt(value);
	                    		goods.setType_id(selectType);
	                    	} else if (filedName.equals("inputTitle")) {
	                    		goods.setName(value);
	                    	} else if (filedName.equals("inputPrice")) {
	                    		double inputPrice = Double.parseDouble(value);
	                    		goods.setPrice(inputPrice);
	                    	} else if (filedName.equals("inputDesc")) {
	                    		goods.setDesc(value);
	                    	}
	                    }
	                }
	                
	                goods.setAmount(1);
	                goods.setStatus(1);
	                goods.setSeller_id(user.getId());
	                
					if (g_service.addGoods(goods)) {
						// 重定向到主页
						response.sendRedirect("index");
					}
				}
			} else {
				response.sendRedirect("index");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
