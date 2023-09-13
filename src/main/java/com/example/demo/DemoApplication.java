package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		openChromeBrowser("http://localhost:8080");
	}

	private static void openChromeBrowser(String url) {
		String os = System.getProperty("os.name").toLowerCase();
		Runtime runtime = Runtime.getRuntime();

		try {
			if (os.contains("win")) {
				runtime.exec("cmd /c start chrome " + url);
			} else {
				throw new UnsupportedOperationException("지원되지 않는 OS입니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("자동으로 브라우저를 열 수 없습니다. 다음 URL로 접속해 주세요: " + url);
		}
	}
}
