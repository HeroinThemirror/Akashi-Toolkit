package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rikka on 2016/6/28.
 */
public class NewShip {
    @Expose private int id;
    @Expose @SerializedName("wiki_id") private String wiki_id;
    private int sort_no;
    @SerializedName("name") private String name_jp;
    @SerializedName("chinese_name") private String name_cn;
    private String yomi;
    @Expose private MultiLanguageEntry name2;
    @Expose private int stype;
    @Expose private int ctype;
    @Expose private int cnum;
    @Expose private int rarity;
    @Expose private String name_for_search;

    @Expose private int build_time;
    @Expose private int[] broken;
    @Expose private int[] power_up;
    @Expose private int[] consume;

    @Expose
    private List<Integer> extra_equip_type;

    public List<Integer> getExtraEquipType() {
        if (extra_equip_type == null) {
            extra_equip_type = new ArrayList<>();
        }
        return extra_equip_type;
    }

    public void setExtraEquipType(List<Integer> extra_equip_type) {
        this.extra_equip_type = extra_equip_type;
    }

    public int[] getResourceConsume() {
        return consume;
    }

    public void setResourceConsume(int[] consume) {
        this.consume = consume;
    }

    public int[] getModernizationBonus() {
        return power_up;
    }

    public void setModernizationBonus(int[] power_up) {
        this.power_up = power_up;
    }

    public int[] getBrokenResources() {
        return broken;
    }

    public void setBrokenResources(int[] broken) {
        this.broken = broken;
    }

    public int getBuildTime() {
        return build_time;
    }

    public void setBuildTime(int build_time) {
        this.build_time = build_time;
    }

    private int after_lv;
    private String after_ship_id;
    private String get_mes;
    private int voice_f;
    private String filename;
    private String book_sinfo;

    private StatsEntity stats;
    private GraphEntity graph;
    private String stype_name;
    private String stype_name_chinese;
    private String swf;
    private List<String> file_version;
    private List<Integer> book_table_id;

    public String getNameForSearch() {
        return name_for_search;
    }

    public void setNameForSearch(String nameForSearch) {
        this.name_for_search = nameForSearch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort_no() {
        return sort_no;
    }

    public void setSort_no(int sort_no) {
        this.sort_no = sort_no;
    }

    public MultiLanguageEntry getName() {
        return name2;
    }

    public void setName(MultiLanguageEntry name) {
        this.name2 = name;
    }

    public String getYomi() {
        return yomi;
    }

    public void setYomi(String yomi) {
        this.yomi = yomi;
    }

    public int getType() {
        return stype;
    }

    public void setType(int type) {
        this.stype = type;
    }

    public int getClassType() {
        return ctype;
    }

    public void setClassType(int classType) {
        this.ctype = classType;
    }

    public int getClassNum() {
        return cnum;
    }

    public void setClassNum(int classNum) {
        this.cnum = classNum;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getAfter_lv() {
        return after_lv;
    }

    public void setAfter_lv(int after_lv) {
        this.after_lv = after_lv;
    }

    public String getAfter_ship_id() {
        return after_ship_id;
    }

    public void setAfter_ship_id(String after_ship_id) {
        this.after_ship_id = after_ship_id;
    }

    public String getGet_mes() {
        return get_mes;
    }

    public void setGet_mes(String get_mes) {
        this.get_mes = get_mes;
    }

    public int getVoice_f() {
        return voice_f;
    }

    public void setVoice_f(int voice_f) {
        this.voice_f = voice_f;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBook_sinfo() {
        return book_sinfo;
    }

    public void setBook_sinfo(String book_sinfo) {
        this.book_sinfo = book_sinfo;
    }

    public StatsEntity getStats() {
        return stats;
    }

    public void setStats(StatsEntity stats) {
        this.stats = stats;
    }

    public GraphEntity getGraph() {
        return graph;
    }

    public void setGraph(GraphEntity graph) {
        this.graph = graph;
    }

    public String getWikiId() {
        return wiki_id;
    }

    public void setWikiId(String wikiId) {
        this.wiki_id = wikiId;
    }

    public String getNameCN() {
        return name_cn;
    }

    public void setNameCN(String nameCN) {
        this.name_cn = nameCN;
    }

    public String getNameJP() {
        return name_jp;
    }

    public void setNameJP(String nameJP) {
        this.name_jp = nameJP;
    }

    public String getStype_name() {
        return stype_name;
    }

    public void setStype_name(String stype_name) {
        this.stype_name = stype_name;
    }

    public String getStype_name_chinese() {
        return stype_name_chinese;
    }

    public void setStype_name_chinese(String stype_name_chinese) {
        this.stype_name_chinese = stype_name_chinese;
    }

    public String getSwf() {
        return swf;
    }

    public void setSwf(String swf) {
        this.swf = swf;
    }

    public List<String> getFile_version() {
        return file_version;
    }

    public void setFile_version(List<String> file_version) {
        this.file_version = file_version;
    }

    public List<Integer> getBook_table_id() {
        return book_table_id;
    }

    public void setBook_table_id(List<Integer> book_table_id) {
        this.book_table_id = book_table_id;
    }

    @Expose private EquipEntity equip;

    public EquipEntity getEquip() {
        return equip;
    }

    public void setEquip(EquipEntity equip) {
        this.equip = equip;
    }

    public static class EquipEntity {
        @Expose private int slots;
        @Expose private int[] id;
        @Expose private int[] space;

        public int getSlots() {
            return slots;
        }

        public int[] getId() {
            return id;
        }

        public int[] getSpace() {
            return space;
        }

        public void setSlots(int slots) {
            this.slots = slots;
        }

        public void setIds(int id1, int id2, int id3, int id4, int id5) {
            this.id = new int[]{id1, id2, id3, id4, id5};
        }

        public void setSpaces(int id1, int id2, int id3, int id4, int id5) {
            this.space = new int[]{id1, id2, id3, id4, id5};
        }
    }

    @Expose private RemodelEntity remodel;

    public RemodelEntity getRemodel() {
        return remodel;
    }

    public void setRemodel(RemodelEntity remodel) {
        this.remodel = remodel;
    }

    public static class RemodelEntity {
        @Expose @SerializedName("blueprint") private boolean requireBlueprint;
        @Expose @SerializedName("from_id") private int fromId;
        @Expose @SerializedName("to_id") private int toId;
        @Expose private int level;
        @Expose private int[] cost;

        public boolean isRequireBlueprint() {
            return requireBlueprint;
        }

        public void setRequireBlueprint(boolean requireBlueprint) {
            this.requireBlueprint = requireBlueprint;
        }

        public void setRequireBlueprint(int requireBlueprint) {
            this.requireBlueprint = requireBlueprint == 1;
        }

        public int getFromId() {
            return fromId;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public void setFromId(String fromId) {
            this.fromId = Integer.parseInt(fromId);
        }

        public int getToId() {
            return toId;
        }

        public void setToId(int toId) {
            this.toId = toId;
        }

        public void setToId(String toId) {
            this.toId = Integer.parseInt(toId);
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setLevel(String level) {
            this.level = Integer.parseInt(level);
        }

        public int[] getCost() {
            return cost;
        }

        public void setCost(int[] cost) {
            this.cost = cost;
        }

        public void setCost(int ammo, int fuel) {
            this.cost = new int[]{ammo, fuel};
        }
    }

    @Expose private AttrEntity attr;
    @Expose
    private AttrEntityMax attr_max;
    @Expose
    private AttrEntity99 attr_99;
    @Expose
    private AttrEntity99 attr_155;

    public AttrEntity99 getAttr99() {
        if (attr_99 == null) {
            attr_99 = new AttrEntity99();
        }
        return attr_99;
    }

    public AttrEntity99 getAttr155() {
        if (attr_155 == null) {
            attr_155 = new AttrEntity99();
        }
        return attr_155;
    }

    public AttrEntityMax getAttrMax() {
        if (attr_max == null) {
            attr_max = new AttrEntityMax();
        }
        return attr_max;
    }

    public AttrEntity getAttr() {
        if (attr == null) {
            attr = new AttrEntity();
        }
        return attr;
    }

    public static class AttrEntity {
        @Expose private int range;
        @Expose private int speed;
        @Expose
        private int aa;
        @Expose
        private int armor;
        @Expose
        private int asw;
        @Expose
        private int evasion;
        @Expose
        private int fire;
        @Expose
        private int hp;
        @Expose
        private int luck;
        @Expose
        private int los;
        @Expose
        private int torpedo;
        private int bomb;
        private int accuracy;

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setAA(int aa) {
            this.aa = aa;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public void setASW(int asw) {
            this.asw = asw;
        }

        public void setEvasion(int evasion) {
            this.evasion = evasion;
        }

        public void setFirepower(int fire) {
            this.fire = fire;
        }

        public void setHP(int hp) {
            this.hp = hp;
        }

        public void setLuck(int luck) {
            this.luck = luck;
        }

        public void setLOS(int los) {
            this.los = los;
        }

        public void setTorpedo(int torpedo) {
            this.torpedo = torpedo;
        }

        public void setBombing(int bomb) {
            this.bomb = bomb;
        }

        public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
        }

        public int getRange() {
            return range;
        }

        public void setRange(int range) {
            this.range = range;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = Integer.parseInt(speed);
        }

        public int getAA() {
            return aa;
        }

        public int getArmor() {
            return armor;
        }

        public int getASW() {
            return asw;
        }

        public int getEvasion() {
            return evasion;
        }

        public int getFirepower() {
            return fire;
        }

        public int getHP() {
            return hp;
        }

        public int getLuck() {
            return luck;
        }

        public int getLOS() {
            return los;
        }

        public int getTorpedo() {
            return torpedo;
        }

        public int getBombing() {
            return bomb;
        }

        public int getAccuracy() {
            return accuracy;
        }
    }

    public static class AttrEntityMax {
        @Expose
        private int aa;
        @Expose
        private int armor;
        @Expose
        private int fire;
        @Expose
        private int luck;
        @Expose
        private int torpedo;

        public void setAA(int aa) {
            this.aa = aa;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public void setFirepower(int fire) {
            this.fire = fire;
        }

        public void setLuck(int luck) {
            this.luck = luck;
        }

        public void setTorpedo(int torpedo) {
            this.torpedo = torpedo;
        }

        public int getArmor() {
            return armor;
        }

        public int getFirepower() {
            return fire;
        }

        public int getLuck() {
            return luck;
        }

        public int getTorpedo() {
            return torpedo;
        }
    }

    public static class AttrEntity99 {
        @Expose
        private int asw;
        @Expose
        private int evasion;
        @Expose
        private int hp;
        @Expose
        private int los;

        public void setASW(int asw) {
            this.asw = asw;
        }

        public void setEvasion(int evasion) {
            this.evasion = evasion;
        }

        public void setHP(int hp) {
            this.hp = hp;
        }

        public void setLOS(int los) {
            this.los = los;
        }

        public int getASW() {
            return asw;
        }

        public int getEvasion() {
            return evasion;
        }

        public int getHP() {
            return hp;
        }

        public int getLOS() {
            return los;
        }
    }

    public static class StatsEntity {
        @SerializedName("soku") private int speed;
        @SerializedName("leng") private int range;
        private int kaih;
        private int tais;
        private int slot_num;
        private int after_fuel;
        private int after_bull;
        private int fuel_max;
        private int bull_max;
        private int build_time;
        @SerializedName("taik") private List<Integer> hp;
        @SerializedName("souk") private List<Integer> armor;
        @SerializedName("houg") private List<Integer> firepower;
        @SerializedName("raig") private List<Integer> torpedo;
        @SerializedName("tyku") private List<Integer> aa;
        private List<Integer> luck;
        private List<Integer> max_eq;
        private List<Integer> broken;
        private List<Integer> pow_up;

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getRange() {
            return range;
        }

        public void setRange(int range) {
            this.range = range;
        }

        public int getKaih() {
            return kaih;
        }

        public void setKaih(int kaih) {
            this.kaih = kaih;
        }

        public int getTais() {
            return tais;
        }

        public void setTais(int tais) {
            this.tais = tais;
        }

        public int getSlot_num() {
            return slot_num;
        }

        public void setSlot_num(int slot_num) {
            this.slot_num = slot_num;
        }

        public int getAfter_fuel() {
            return after_fuel;
        }

        public void setAfter_fuel(int after_fuel) {
            this.after_fuel = after_fuel;
        }

        public int getAfter_bull() {
            return after_bull;
        }

        public void setAfter_bull(int after_bull) {
            this.after_bull = after_bull;
        }

        public int getFuel_max() {
            return fuel_max;
        }

        public void setFuel_max(int fuel_max) {
            this.fuel_max = fuel_max;
        }

        public int getBull_max() {
            return bull_max;
        }

        public void setBull_max(int bull_max) {
            this.bull_max = bull_max;
        }

        public int getBuild_time() {
            return build_time;
        }

        public void setBuild_time(int build_time) {
            this.build_time = build_time;
        }

        public List<Integer> getHP() {
            return hp;
        }

        public void setHp(List<Integer> hp) {
            this.hp = hp;
        }

        public List<Integer> getArmor() {
            return armor;
        }

        public void setArmor(List<Integer> armor) {
            this.armor = armor;
        }

        public List<Integer> getFirepower() {
            return firepower;
        }

        public void setFirepower(List<Integer> firepower) {
            this.firepower = firepower;
        }

        public List<Integer> getTorpedo() {
            return torpedo;
        }

        public void setTorpedo(List<Integer> torpedo) {
            this.torpedo = torpedo;
        }

        public List<Integer> getAA() {
            return aa;
        }

        public void setAA(List<Integer> aa) {
            this.aa = aa;
        }

        public List<Integer> getLuck() {
            return luck;
        }

        public void setLuck(List<Integer> luck) {
            this.luck = luck;
        }

        public List<Integer> getMax_eq() {
            return max_eq;
        }

        public void setMax_eq(List<Integer> max_eq) {
            this.max_eq = max_eq;
        }

        public List<Integer> getBroken() {
            return broken;
        }

        public void setBroken(List<Integer> broken) {
            this.broken = broken;
        }

        public List<Integer> getPow_up() {
            return pow_up;
        }

        public void setPow_up(List<Integer> pow_up) {
            this.pow_up = pow_up;
        }
    }

    public static class GraphEntity {
        private List<Integer> boko_n;
        private List<Integer> boko_d;
        private List<Integer> kaisyu_n;
        private List<Integer> kaisyu_d;
        private List<Integer> kaizo_n;
        private List<Integer> kaizo_d;
        private List<Integer> map_n;
        private List<Integer> map_d;
        private List<Integer> ensyuf_n;
        private List<Integer> ensyuf_d;
        private List<Integer> ensyue_n;
        private List<Integer> battle_n;
        private List<Integer> battle_d;
        private List<Integer> wed_a;
        private List<Integer> wed_b;

        public List<Integer> getBoko_n() {
            return boko_n;
        }

        public void setBoko_n(List<Integer> boko_n) {
            this.boko_n = boko_n;
        }

        public List<Integer> getBoko_d() {
            return boko_d;
        }

        public void setBoko_d(List<Integer> boko_d) {
            this.boko_d = boko_d;
        }

        public List<Integer> getKaisyu_n() {
            return kaisyu_n;
        }

        public void setKaisyu_n(List<Integer> kaisyu_n) {
            this.kaisyu_n = kaisyu_n;
        }

        public List<Integer> getKaisyu_d() {
            return kaisyu_d;
        }

        public void setKaisyu_d(List<Integer> kaisyu_d) {
            this.kaisyu_d = kaisyu_d;
        }

        public List<Integer> getKaizo_n() {
            return kaizo_n;
        }

        public void setKaizo_n(List<Integer> kaizo_n) {
            this.kaizo_n = kaizo_n;
        }

        public List<Integer> getKaizo_d() {
            return kaizo_d;
        }

        public void setKaizo_d(List<Integer> kaizo_d) {
            this.kaizo_d = kaizo_d;
        }

        public List<Integer> getMap_n() {
            return map_n;
        }

        public void setMap_n(List<Integer> map_n) {
            this.map_n = map_n;
        }

        public List<Integer> getMap_d() {
            return map_d;
        }

        public void setMap_d(List<Integer> map_d) {
            this.map_d = map_d;
        }

        public List<Integer> getEnsyuf_n() {
            return ensyuf_n;
        }

        public void setEnsyuf_n(List<Integer> ensyuf_n) {
            this.ensyuf_n = ensyuf_n;
        }

        public List<Integer> getEnsyuf_d() {
            return ensyuf_d;
        }

        public void setEnsyuf_d(List<Integer> ensyuf_d) {
            this.ensyuf_d = ensyuf_d;
        }

        public List<Integer> getEnsyue_n() {
            return ensyue_n;
        }

        public void setEnsyue_n(List<Integer> ensyue_n) {
            this.ensyue_n = ensyue_n;
        }

        public List<Integer> getBattle_n() {
            return battle_n;
        }

        public void setBattle_n(List<Integer> battle_n) {
            this.battle_n = battle_n;
        }

        public List<Integer> getBattle_d() {
            return battle_d;
        }

        public void setBattle_d(List<Integer> battle_d) {
            this.battle_d = battle_d;
        }

        public List<Integer> getWed_a() {
            return wed_a;
        }

        public void setWed_a(List<Integer> wed_a) {
            this.wed_a = wed_a;
        }

        public List<Integer> getWed_b() {
            return wed_b;
        }

        public void setWed_b(List<Integer> wed_b) {
            this.wed_b = wed_b;
        }
    }
}
