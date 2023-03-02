package JavaGuide.spiTest;

/**
 * @autor wwl
 * @date 2022/10/14-15:29
 */
public class Main {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();

        service.info("Hello SPI");
        service.debug("Hello SPI");
    }
}
