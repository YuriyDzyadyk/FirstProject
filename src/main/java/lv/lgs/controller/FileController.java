package lv.lgs.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import lv.lgs.serviceImplementation.FileUpdatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@Autowired
	FileUpdatingService fileUpdatingService;

	@RequestMapping(value = "/sitemap/upload", method = RequestMethod.POST)

	public String uploadPost(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "id") String carId
	// ��� ���� ��� ������� ����//String carId �� ������ Id ������ ��� ����
	// ������������...�� ��� �������� � ���������� ������

	) {
		String path = fileUpdatingService.writeFile(carId, file);
		// -- �� ������ �������� � ��� (�� �� ����� �������)

		return "redirect:/sitemap";

	}

	@RequestMapping(value = "/sitemap/upload/")
	public String uploadGet(@RequestParam(value = "file") MultipartFile file, String carId
	// ��� ���� ��� ������� ���� //String carId �� ������ Id ������ ��� ����
	// ������������...�� ��� �������� � ���������� ������
	) {

		return "sitemap";
	}

	@RequestMapping(value = "sitemap/upload/{path}.png")
	// ������ �������� �������� � ����� .png (� �����������)
	public void allLogoImagePng(@PathVariable String path, Model model, HttpServletResponse response)
			throws IOException {
		InputStream is = new FileInputStream(
				new File(System.getProperty("catalina.home") + "/sitemap/upload" + path + ".png"));
		BufferedInputStream inputStream = new BufferedInputStream(is);
		int nRead;
		byte[] b = new byte[10000];
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		while ((nRead = inputStream.read(b, 0, b.length)) != -1) {
			arrayOutputStream.write(b, 0, nRead);
		}
		arrayOutputStream.flush();
		byte[] bn = arrayOutputStream.toByteArray();
		response.setContentType("image/jpeg");
		response.setContentLength(bn.length);
		OutputStream os = response.getOutputStream();
		os.write(bn);
		os.flush();
		os.close();
		inputStream.close();
	}

	@RequestMapping(value = "sitemap/upload/{path}.jpeg")
	// ������ �������� �������� � ����� .jpeg (� �����������)
	public void allLogoImageJpeg(@PathVariable String path, Model model, HttpServletResponse response)
			throws IOException {
		InputStream is = new FileInputStream(
				new File(System.getProperty("catalina.home") + "/sitemap/upload" + path + ".png"));
		BufferedInputStream inputStream = new BufferedInputStream(is);
		int nRead;
		byte[] b = new byte[10000];
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		while ((nRead = inputStream.read(b, 0, b.length)) != -1) {
			arrayOutputStream.write(b, 0, nRead);
		}
		arrayOutputStream.flush();
		byte[] bn = arrayOutputStream.toByteArray();
		response.setContentType("image/jpeg");
		response.setContentLength(bn.length);
		OutputStream os = response.getOutputStream();
		os.write(bn);
		os.flush();
		os.close();
		inputStream.close();
	}

	@RequestMapping(value = "sitemap/upload/{path}.jpg")
	// ������ �������� �������� � ����� .jpg (� �����������)
		public void allLogoImageJpg(@PathVariable String path, Model model, HttpServletResponse response)
			throws IOException {
		InputStream is = new FileInputStream(
				new File(System.getProperty("catalina.home") + "/sitemap/upload" + path + ".png"));
		BufferedInputStream inputStream = new BufferedInputStream(is);
		int nRead;
		byte[] b = new byte[10000];
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		while ((nRead = inputStream.read(b, 0, b.length)) != -1) {
			arrayOutputStream.write(b, 0, nRead);
		}
		arrayOutputStream.flush();
		byte[] bn = arrayOutputStream.toByteArray();
		response.setContentType("image/jpeg");
		response.setContentLength(bn.length);
		OutputStream os = response.getOutputStream();
		os.write(bn);
		os.flush();
		os.close();
		inputStream.close();
	}

}
