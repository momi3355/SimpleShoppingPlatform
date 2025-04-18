package co.yedam.control.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class ConfigReaderControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		ServletContext context = req.getServletContext();
        InputStream inputStream = context.getResourceAsStream("/assets/config.json"); // assets/data.json 파일 읽기

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                resp.getWriter().println("{ \"retCode\": \"200\", \"datas\": "+content.toString()+"}");
            } catch (IOException e) {
            	resp.getWriter().println("{ \"retCode\":  \"500\", \"Error reading file\": \"" + e.getMessage()+"\"}");
            } finally {
                inputStream.close();
            }
        } else {
        	resp.getWriter().println("{ \"retCode\":  \"404\", \"File not found\": \"assets/data.json\"}");
        }
	}
}
