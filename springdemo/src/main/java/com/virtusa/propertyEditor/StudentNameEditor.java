package com.virtusa.propertyEditor;


import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {



	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		if(text.contains("Mr.") || text.contains("Ms."))
			setValue(text);
		else {
			text = "Mr."+text;
			setValue(text);
		}
		
	}


	

}
