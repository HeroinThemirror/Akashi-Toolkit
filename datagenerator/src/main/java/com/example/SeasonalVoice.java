package com.example;

import com.example.model.ShipVoice;
import com.example.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.utils.Utils.getUrlStream;

public class SeasonalVoice {

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList<>();

        boolean needNextLine = false;
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.equals("{{台词翻译表|type=seasonal") && !needNextLine) {
                needNextLine = true;
                sb = new StringBuilder();
            }

            if (needNextLine) {
                sb.append(line);
            }

            if (needNextLine && line.equals("}}")) {
                parse(list, sb.toString());
                needNextLine = false;
            }

            if (line.equals("end")) {
                break;
            }

            if (!needNextLine) {
                parse(list, line);
            }
        }

        print(list);
    }

    private static void print(List<Object> list) {
        System.out.println("$data = null;");
        System.out.println("$data['type'] = $TYPE_VOICE;");
        System.out.println("$data['title'] = \"title\";");
        System.out.println("$data['summary'] = \"summary\";");
        System.out.println("$data['voice'] = array();");
        System.out.println();

        boolean print = false;
        for (Object obj : list) {
            if (obj instanceof String) {
                if (print) {
                    System.out.println("array_push($data['voice'], $data_voice);");
                }

                print = true;

                System.out.println("$data_voice = null;");
                System.out.println("$data_voice['type'] = \"" + obj + "\";");
                System.out.println("$data_voice['voice'] = array();");
                System.out.println();
            }

            if (obj instanceof ShipVoice) {
                ShipVoice item = (ShipVoice) obj;
                System.out.println("$data_voice_obj = null;");
                System.out.println("$data_voice_obj['zh'] = \"" + item.getZh() + "\";");
                System.out.println("$data_voice_obj['jp'] = \"" + item.getJp() + "\";");
                System.out.println("$data_voice_obj['scene'] = \"" + item.getScene() + "\";");
                System.out.println("$data_voice_obj['url'] = \"" + item.getUrl() + "\";");
                System.out.println("array_push($data_voice['voice'], $data_voice_obj);");
                System.out.println();
            }
        }

        System.out.println("array_push($data['voice'], $data_voice);");
        System.out.println("array_push($json, $data);");
    }

    private static Pattern TYPE_PATTERN = Pattern.compile("===([^=]+)===");
    private static Pattern VOICE_PATTERN = Pattern.compile("\\{\\{台词翻译表\\|type=seasonal\\|档名=(.+)\\|.+舰娘名字=(.+)\\|日文台词=(.+)\\|中文译文=(.+)}}".replace(" ", "").replace("\n", ""));

    //\\{\\{ruby-[^\\|]+\\|(.+)\\|(.+)}}
    //<ref>([^<]+)<\/ref>
    //\{\{lang\|.+\|(.+)}}
    private static void parse(List<Object> list, String line) {

        Matcher m = TYPE_PATTERN.matcher(line);
        if (m.find()) {
            list.add(m.group(1));
        } else {
            m = VOICE_PATTERN.matcher(line.replace(" ", ""));

            if (m.find()) {
                ShipVoice item = new ShipVoice();
                item.setUrl(m.group(1) + ".mp3");
                item.setScene(m.group(2));
                item.setJp(parseString(m.group(3)));
                item.setZh(parseString(m.group(4)));
                list.add(item);
            }
        }
    }

    private static String parseString(String str) {
        return str.replaceAll("\\{\\{lang\\|.+\\|(.+)}}", "$1")
                .replaceAll("\\{\\{ruby-[^\\|]+\\|(.+)\\|(.+)}}", "$1 ($2)"
                        .replaceAll("\\{\\{lang\\|.+\\|(.+)}}", "$1"))
                .replaceAll("<ref>([^<]+)</ref>", "");
    }
}
