/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapandinstance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class Main2Map {

    private final Map<String, BaseInstance> instanceMapper;

    @Inject
    Main2Map(Instance<BaseInstance> instances){

        instanceMapper = instances.stream().collect(Collectors.toMap(BaseInstance::getType, Function.identity()));
    }

    void mainMethod2(String type){
        var instance = instanceMapper.get(type);
        instance.baseTest();
    }
}
