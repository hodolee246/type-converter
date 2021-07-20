package hello.typeconverter.converter;

import hello.typeconverter.converter.type.IpPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    StringToIntegerConverter stringToIntegerConverter;
    IntegerToStringConverter integerToStringConverter;
    StringToIpPortConverter stringToIpPortConverter;
    IpPortToStringConverter ipPortToStringConverter;

    @BeforeEach
    void setUp() {
        stringToIntegerConverter = new StringToIntegerConverter();
        integerToStringConverter = new IntegerToStringConverter();
        stringToIpPortConverter = new StringToIpPortConverter();
        ipPortToStringConverter = new IpPortToStringConverter();
    }

    @Test
    void stringToInteger() {
        Integer result = stringToIntegerConverter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        String result = integerToStringConverter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = ipPortToStringConverter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString() {
        String source = "127.0.0.1:8080";
        IpPort result = stringToIpPortConverter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

}
