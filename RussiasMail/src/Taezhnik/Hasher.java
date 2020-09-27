package Taezhnik;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Hasher {

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String getHash(String text) {
        String hash = "";
        String algorithm = "SHA3-256";
        //String algorithm = "SHA-256"; output len:64, 256bit
        byte[] shaInBytes = Hasher.digest(text.getBytes(StandardCharsets.UTF_8), algorithm);
        return bytesToHex(shaInBytes);
    }

    public static ArrayList<String> createAllHashs(ArrayList<String>... arrayLists) {
        ArrayList<String> all_hashs = arrayLists[0];
        /*ArrayList<String> all_hashs = new ArrayList<>();
        for(String elem: arrayLists[0]){
            all_hashs.add(elem);
        }*/

        int len_array_lists = arrayLists.length;
        for (int i = 1; i < len_array_lists; i++) {
            int len_first = all_hashs.size();
            int len_second = arrayLists[i].size();
            //System.out.println(len_first);
            //System.out.println(len_second);
            ArrayList<String> hash = new ArrayList<String>();

            for (int j = 0; j < len_first; j++) {
                for (int k = 0; k < len_second; k++) {
                    hash.add(getHash(all_hashs.get(j) + arrayLists[i].get(k)));
                }
            }
            all_hashs = hash;
            //System.out.println(hash.size());
        }
        //System.out.println(all_hashs.size());
        return all_hashs;
    }
}

