package demo.springmvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String UPLOAD_DIRECTORY = "/images";

	@RequestMapping(value = "/upload",method = RequestMethod.GET)
	public ModelAndView uploadForm() {
		return new ModelAndView("fileUpload");
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session)
			throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		File tmpFile = new File(path);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}
		String filename = file.getOriginalFilename();
		System.out.println(path + File.separator + filename);
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("success", "filesuccess", path + File.separator + filename);
	}
	@RequestMapping(value = "/upload1",method = RequestMethod.GET)
	public ModelAndView uploadForm1() {
		return new ModelAndView("Spring Ajax File Upload");
	}
	@RequestMapping(value = "/ajaxsave", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ModelAndView uploadfilePoint(@RequestParam("myfileUpload") MultipartFile multipart, HttpSession session) throws Exception {
	
		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			File tmpFile = new File(path);
			if (!tmpFile.exists()) {
				tmpFile.mkdir();
			}
			String filename = multipart.getOriginalFilename();
			System.out.println(path + File.separator + filename);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(multipart.getBytes());
			stream.flush();
			stream.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("success", "filesuccess", multipart.getOriginalFilename());
	}

	@RequestMapping(value = "/swim", method = RequestMethod.GET)
	public void getImageAsByteArray(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/imgs/swim.jpg");
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
}
