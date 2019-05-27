package com.shaozj.sdk.qy.api.bean.resp.message.converter;

import com.thoughtworks.xstream.converters.basic.StringConverter;

public class CDataConverter extends StringConverter {
    
    @Override
    public String toString(Object obj) {
      return "<![CDATA[" + super.toString(obj) + "]]>";
    }
}
