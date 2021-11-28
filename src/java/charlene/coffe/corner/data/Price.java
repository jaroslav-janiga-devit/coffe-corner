package charlene.coffe.corner.data;

import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;

public interface Price {

    default BigDecimal getPrice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("price is not defined");
    }

}
