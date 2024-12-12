package com.shaik.acknowledge.conditionalonproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "conditional.on.property", name = "value", havingValue = "1", matchIfMissing = false)
public class ConditionalOnProperty_1 {


    public ConditionalOnProperty_1() {
        System.out.println("*************************** conditional on property_1 obj created ***************************");
    }
}
