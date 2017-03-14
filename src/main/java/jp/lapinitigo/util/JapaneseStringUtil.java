package jp.lapinitigo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 日本語文字列ユーティリティ
 * @author lapin
 */
public class JapaneseStringUtil {

    public static final Map<String, String> furiganaMap = new HashMap<String, String>(){
            private static final long serialVersionUID = 1L;
        {
            put("あ","a");put("い","i");put("う","u");put("え","e");put("お","o");
            put("か","ka");put("き","ki");put("く","ku");put("け","ke");put("こ","ko");
            put("さ","sa");put("し","shi");put("す","su");put("せ","se");put("そ","so");
            put("た","ta");put("ち","ti");put("つ","tu");put("て","te");put("と","to");
            put("な","na");put("に","ni");put("ぬ","nu");put("ね","ne");put("の","no");
            put("は","ha");put("ひ","hi");put("ふ","hu");put("へ","he");put("ほ","ho");
            put("ま","ma");put("み","mi");put("む","mu");put("め","me");put("も","mo");
            put("や","ya");put("ゆ","yu");put("よ","yo");
            put("ら","ra");put("り","ri");put("る","ru");put("れ","re");put("ろ","ro");
            put("わ","wa");put("を","wo");put("ん","n");
            put("が","ga");put("ぎ","gi");put("ぐ","gu");put("げ","ge");put("ご","go");
            put("ざ","za");put("じ","zi");put("ず","zu");put("ぜ","ze");put("ぞ","zo");
            put("だ","da");put("ぢ","di");put("づ","du");put("で","de");put("ど","do");
            put("ば","ba");put("び","bi");put("ぶ","bu");put("べ","be");put("ぼ","bo");
            put("ゔ","v");
            put("ぁ","xa");put("ぃ","xi");put("ぅ","xu");put("ぇ","xe");put("ぉ","xo");
            put("ゃ","xya");put("ゅ","xyu");put("ょ","xyo");
            put("っ","xtu");
            put("ぱ","pa");put("ぴ","pi");put("ぷ","pu");put("ぺ","pe");put("ぽ","po");
            put("ー","");
            // 二文字
            put("kixya","kya");put("kixyu","kyu");put("kixyo","kyo");
            put("shixya","sha");put("shixyu","shu");put("shixyo","sho");
            put("hixya","hya");put("hixyi","hyi");put("hixyu","hyu");put("hixye","hye");put("hixyo","hyo");
            put("huxya","fa");put("huxyi","fi");put("huxye","fe");put("huyxo","fo");
            put("gixya","gya");put("gixyu","gyu");put("gixyo","gyo");
            put("zixya","ja");put("zixyu","ju");put("zixyo","jo");
            put("dexi","di");
        }};
    
    public static final String getAlphaFromFurigana(String furigana) {
        if(StringUtil.isNullOrEmpty(furigana)) {
            return null;
        }
        // 一文字目を変換
        String furigana1 = furigana.substring(0,1);
        String alpha1 = furiganaMap.get(furigana1);
        
        if(furigana.length() == 1) {
            return alpha1;
        }
        
        String furigana2 = furigana.substring(1,2);
        String alpha2 = furiganaMap.get(furigana2);
        
        String result = alpha1 + alpha2;
        
        boolean more = false;
        
        if("".equals(alpha2)) {
            more = true;
        }
        // 二文字でヒットした場合はそれを採用
        if(furiganaMap.containsKey(result)) {
            result = furiganaMap.get(result);
            more = true;
        }

        if(more && furigana.length() != 2) {
            String furigana3 = furigana.substring(2,3);
            String alpha3 = furiganaMap.get(furigana3);
            if(furiganaMap.containsKey(alpha2 + alpha3)) {
                result = alpha1 + furiganaMap.get(alpha2 + alpha3);
                more = true;
            } else {
                result += alpha3;
            }
        }
        
        return result;
    }
    

}
