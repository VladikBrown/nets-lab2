package com.vladbrown.netslabs.lab2.web.src.converters;

import java.util.List;

public interface Converter<Source, Target> {

    Target convert(Source source);

    Target convert(Source source, Target target);

    List<Target> convertAll(List<Source> source);
}
