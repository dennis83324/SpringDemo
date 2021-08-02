package com.example.demo;
import org.springframework.stereotype.Component;


public class HoPrinter implements Printer{
	public void print (String message) {
		System.out.println("Ho印表機 : " + message);
	}
}
