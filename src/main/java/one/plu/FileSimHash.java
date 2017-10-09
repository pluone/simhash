package one.plu;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Slf4j
public class FileSimHash {
    public List<Long> getFileLinesSimHashList() throws IOException {
        List<Long> list = new ArrayList<>();


        File file = getFile("test_data.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                SimHash simHash = new SimHash();
                list.add(simHash.simhash64(line));
            }
        }
        return list;
    }

    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
        URL url = classLoader.getResource(fileName);
        /**
         * url.getFile() 得到这个文件的绝对路径
         */
        System.out.println(url.getFile());
        File file = new File(url.getFile());
        System.out.println(file.exists());
        return file;
    }

    public Map getMap() throws IOException {
        Map map = new HashMap();
        File file = getFile("test_data.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                SimHash simHash = new SimHash();
                map.put(simHash.simhash64(line), line);
            }
        }
        return map;
    }

    public Map getSortedMap() throws IOException {
        Map map = new HashMap();
        File file = getFile("test_data.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                SimHash simHash = new SimHash();
                map.put(simHash.simhash64(line), line);
            }
        }
        TreeMap treeMap = new TreeMap(map);

        System.out.println(">>>");
        System.out.println(treeMap);
        log.info("map:",treeMap);
        return treeMap;
    }

    public List<Long> getHammingDistance(SortedMap sortedMap) {
        SortedSet sortedSet = new TreeSet(sortedMap.keySet());

        List<Long> list = new ArrayList(sortedSet);
        List result = new ArrayList();
        SimHash simHash = new SimHash();
        Iterator it = sortedSet.iterator();
        for (int i=0;i<list.size()-1;i++) {
            result.add(simHash.hammingDistance(list.get(i), list.get(i + 1)));
        }
        return result;
    }
}
