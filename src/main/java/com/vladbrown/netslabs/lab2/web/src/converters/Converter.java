package com.vladbrown.netslabs.lab2.web.src.converters;

import java.util.List;

public interface Converter<Source, Target> {

    Target convert(Source source);

    void convert(Source source, Target target);

    List<Target> convertAll(Source source);
}
