package org.abhyan.tradecraft.model;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.abhyan.tradecraft.constants.ConstParameters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<Date>{
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat formatter = new SimpleDateFormat(ConstParameters.DATE_FORMAT);

	public CustomDateSerializer() {
		this(null);
	}

	public CustomDateSerializer(Class t) 
{
	super(t);
}
	
	@Override
	public void serialize(Date value, JsonGenerator jg, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		jg.writeString(formatter.format(value));	
		}
	
}

