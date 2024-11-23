package com.rot.app.migration;


import com.rot.app.migration.raw.RawCsv;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MigrateRawData {

    public static List<String> getLinesFromCsv() {
        List<String> lines = new ArrayList<>();
        Resource resource = new ClassPathResource("raw_data.csv");

        try {
            InputStream inputStream = resource.getInputStream();

            lines = new BufferedReader(new InputStreamReader(inputStream)).lines().toList();
            //File file = resource.getFile();
            //lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static RawCsv createRawCsvFromLine(String line) {

        StringBuilder tempLine = new StringBuilder(line);
        String[] temp = tempLine.toString().split(";");
        if (temp.length < 66) {
            int delta = 66 - temp.length;
            tempLine.append(";".repeat(delta));
            tempLine.append("__END__");
        }
        RawCsv rawCsv = new RawCsv();
        String[] values = tempLine.toString().split(";");
        rawCsv.setRawData(line);
        rawCsv.setA(values[0]);
        rawCsv.setB(values[1]);
        rawCsv.setC(values[2]);
        rawCsv.setD(values[3]);
        rawCsv.setE(values[4]);
        rawCsv.setF(values[5]);
        rawCsv.setG(values[6]);
        rawCsv.setH(values[7]);
        rawCsv.setI(values[8]);
        rawCsv.setJ(values[9]);
        rawCsv.setK(values[10]);
        rawCsv.setL(values[11]);
        rawCsv.setM(values[12]);
        rawCsv.setN(values[13]);
        rawCsv.setO(values[14]);
        rawCsv.setP(values[15]);
        rawCsv.setQ(values[16]);
        rawCsv.setR(values[17]);
        rawCsv.setS(values[18]);
        rawCsv.setT(values[19]);
        rawCsv.setU(values[20]);
        rawCsv.setV(values[21]);
        rawCsv.setW(values[22]);
        rawCsv.setX(values[23]);
        rawCsv.setY(values[24]);
        rawCsv.setZ(values[25]);
        rawCsv.setAa(values[26]);
        rawCsv.setAb(values[27]);
        rawCsv.setAc(values[28]);
        rawCsv.setAd(values[29]);
        rawCsv.setAe(values[30]);
        rawCsv.setAf(values[31]);
        rawCsv.setAg(values[32]);
        rawCsv.setAh(values[33]);
        rawCsv.setAi(values[34]);
        rawCsv.setAj(values[35]);
        rawCsv.setAk(values[36]);
        rawCsv.setAl(values[37]);
        rawCsv.setAm(values[38]);
        rawCsv.setAn(values[39]);
        rawCsv.setAo(values[40]);
        rawCsv.setAp(values[41]);
        rawCsv.setAq(values[42]);
        rawCsv.setAr(values[43]);
        rawCsv.setTas(values[44]);
        rawCsv.setAt(values[45]);
        rawCsv.setAu(values[46]);
        rawCsv.setAv(values[47]);
        rawCsv.setAw(values[48]);
        rawCsv.setAx(values[49]);
        rawCsv.setAy(values[50]);
        rawCsv.setAz(values[51]);
        rawCsv.setBa(values[52]);
        rawCsv.setBb(values[53]);
        rawCsv.setBc(values[54]);
        rawCsv.setBd(values[55]);
        rawCsv.setBe(values[56]);
        rawCsv.setBf(values[57]);
        rawCsv.setBg(values[58]);
        rawCsv.setBh(values[59]);
        rawCsv.setBi(values[60]);
        rawCsv.setBj(values[61]);
        rawCsv.setBk(values[62]);
        rawCsv.setBl(values[63]);
        rawCsv.setBm(values[64]);
        return rawCsv;
    }
}
