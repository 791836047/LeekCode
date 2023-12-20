package com.whl.leekcode.other.design.chainOfResponsibilityPattern.example2;

public interface Handler {

	Boolean process(Request request);

	String getName();

}
