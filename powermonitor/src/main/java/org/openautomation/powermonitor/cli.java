package org.openautomation.powermonitor;

import org.openautomation.powermonitor.dao.HS100;

import java.sql.Timestamp;
import java.util.Map;

public class cli {
    public static void main(String[] args) throws Exception {
        String ip = "192.168.1.159";
        int port = 9999;

        if(args.length > 0) {
            ip = args[0];
        }

        HS100 hs100 = new HS100(ip, port);

        boolean isRunning = true;
        while(isRunning) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Map<String, String> data = hs100.getCurrentPowerUsage();

            //System.out.println(timestamp + " - " + data);
            System.out.println(timestamp + " - " + data.get("power"));

            Thread.sleep(1_000L);
        }
    }
}
