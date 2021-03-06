package com.zukimessenger;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/**
 * Created by manik on 1/1/18.
 */

public class Helper {
    //Server constants
    public static final String IMAGE = "image";
    public static final String VIDEO = "video";
    public static final String GRAPHIC = "graphic";
    public static final String POLL = "poll";
    public static final String FILE = "file";
    public static final String FILE_TYPE = "fileType";
    public static final String MESSAGES = "messages";
    public static final String MEMBERS = "members";
    public static final String USERS = "user";
    public static final String USER = "user";
    public static final String CHATS = "chats";
    public static final String TAGS = "tags";
    public static final String TEXT = "text";
    public static final String NOTIFICATION_TOKENS = "notificationTokens";
    public static final String CHAT_KEY = "chatKey";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String SENDER = "name";

    //Todo: use capital first letter or fix FilesScreen type_spinner content

    //App Constants
    public static final String REQUEST_CODE = "requestCode";
    public static final String CHAT = "chat";
    private static final int REQUEST_STORAGE_ACCESS = 555;

    public static final String APP_FOLDER = Environment.getExternalStorageDirectory().toString()
            + "/zuki/";

    public class Country {
        String[] mCode;
        String mName;

        Country(String name, String[] code) {
            mCode = code;
            mName = name;

        }

        Country(String name, String code) {
            mCode[0] = code;
            mName = name;
        }
    }

    public Country[] getCountries() {
        return new Country[]{
                new Country("Afghanistan", "93"),
                new Country("Albania", "355"),
                new Country("Algeria", "213"),
                new Country("American Samoa", "1-684"),
                new Country("Andorra", "376"),
                new Country("Angola", "244"),
                new Country("Anguilla", "1-264"),
                new Country("Antarctica", "672"),
                new Country("Antigua and Barbuda", "1-268"),
                new Country("Argentina", "54"),
                new Country("Armenia", "374"),
                new Country("Aruba", "297"),
                new Country("Australia", "61"),
                new Country("Austria", "43"),
                new Country("Azerbaijan", "994"),
                new Country("Bahamas", "1-242"),
                new Country("Bahrain", "973"),
                new Country("Bangladesh", "880"),
                new Country("Barbados", "1-246"),
                new Country("Belarus", "375"),
                new Country("Belgium", "32"),
                new Country("Belize", "501"),
                new Country("Benin", "229"),
                new Country("Bermuda", "1-441"),
                new Country("Bhutan", "975"),
                new Country("Bolivia", "591"),
                new Country("Bosnia and Herzegovina", "387"),
                new Country("Botswana", "267"),
                new Country("Brazil", "55"),
                new Country("British Indian Ocean Territory", "246"),
                new Country("British Virgin Islands", "1-284"),
                new Country("Brunei", "673"),
                new Country("Bulgaria", "359"),
                new Country("Burkina Faso", "226"),
                new Country("Burundi", "257"),
                new Country("Cambodia", "855"),
                new Country("Cameroon", "237"),
                new Country("Canada", "1"),
                new Country("Cape Verde", "238"),
                new Country("Cayman Islands", "1-345"),
                new Country("Central African Republic", "236"),
                new Country("Chad", "235"),
                new Country("Chile", "56"),
                new Country("China", "86"),
                new Country("Christmas Island", "61"),
                new Country("Cocos Islands", "61"),
                new Country("Colombia", "57"),
                new Country("Comoros", "269"),
                new Country("Cook Islands", "682"),
                new Country("Costa Rica", "506"),
                new Country("Croatia", "385"),
                new Country("Cuba", "53"),
                new Country("Curacao", "599"),
                new Country("Cyprus", "357"),
                new Country("Czech Republic", "420"),
                new Country("Democratic Republic of the Congo", "243"),
                new Country("Denmark", "45"),
                new Country("Djibouti", "253"),
                new Country("Dominica", "1-767"),
                new Country("Dominican Republic", new String[]{"1-809", "1-829", "1-849"}),
                new Country("East Timor", "670"),
                new Country("Ecuador", "593"),
                new Country("Egypt", "20"),
                new Country("El Salvador", "503"),
                new Country("Equatorial Guinea", "240"),
                new Country("Eritrea", "291"),
                new Country("Estonia", "372"),
                new Country("Ethiopia", "251"),
                new Country("Falkland Islands", "500"),
                new Country("Faroe Islands", "298"),
                new Country("Fiji", "679"),
                new Country("Finland", "358"),
                new Country("France", "33"),
                new Country("French Polynesia", "689"),
                new Country("Gabon", "241"),
                new Country("Gambia", "220"),
                new Country("Georgia", "995"),
                new Country("Germany", "49"),
                new Country("Ghana", "233"),
                new Country("Gibraltar", "350"),
                new Country("Greece", "30"),
                new Country("Greenland", "299"),
                new Country("Grenada", "1-473"),
                new Country("Guam", "1-671"),
                new Country("Guatemala", "502"),
                new Country("Guernsey", "44-1481"),
                new Country("Guinea", "224"),
                new Country("Guinea-Bissau", "245"),
                new Country("Guyana", "592"),
                new Country("Haiti", "509"),
                new Country("Honduras", "504"),
                new Country("Hong Kong", "852"),
                new Country("Hungary", "36"),
                new Country("Iceland", "354"),
                new Country("India", "91"),
                new Country("Indonesia", "62"),
                new Country("Iran", "98"),
                new Country("Iraq", "964"),
                new Country("Ireland", "353"),
                new Country("Isle of Man", "44-1624"),
                new Country("Israel", "972"),
                new Country("Italy", "39"),
                new Country("Ivory Coast", "225"),
                new Country("Jamaica", "1-876"),
                new Country("Japan", "81"),
                new Country("Jersey", "44-1534"),
                new Country("Jordan", "962"),
                new Country("Kazakhstan", "7"),
                new Country("Kenya", "254"),
                new Country("Kiribati", "686"),
                new Country("Kosovo", "383"),
                new Country("Kuwait", "965"),
                new Country("Kyrgyzstan", "996"),
                new Country("Laos", "856"),
                new Country("Latvia", "371"),
                new Country("Lebanon", "961"),
                new Country("Lesotho", "266"),
                new Country("Liberia", "231"),
                new Country("Libya", "218"),
                new Country("Liechtenstein", "423"),
                new Country("Lithuania", "370"),
                new Country("Luxembourg", "352"),
                new Country("Macau", "853"),
                new Country("Macedonia", "389"),
                new Country("Madagascar", "261"),
                new Country("Malawi", "265"),
                new Country("Malaysia", "60"),
                new Country("Maldives", "960"),
                new Country("Mali", "223"),
                new Country("Malta", "356"),
                new Country("Marshall Islands", "692"),
                new Country("Mauritania", "222"),
                new Country("Mauritius", "230"),
                new Country("Mayotte", "262"),
                new Country("Mexico", "52"),
                new Country("Micronesia", "691"),
                new Country("Moldova", "373"),
                new Country("Monaco", "377"),
                new Country("Mongolia", "976"),
                new Country("Montenegro", "382"),
                new Country("Montserrat", "1-664"),
                new Country("Morocco", "212"),
                new Country("Mozambique", "258"),
                new Country("Myanmar", "95"),
                new Country("Namibia", "264"),
                new Country("Nauru", "674"),
                new Country("Nepal", "977"),
                new Country("Netherlands", "31"),
                new Country("Netherlands Antilles", "599"),
                new Country("New Caledonia", "687"),
                new Country("New Zealand", "64"),
                new Country("Nicaragua", "505"),
                new Country("Niger", "227"),
                new Country("Nigeria", "234"),
                new Country("Niue", "683"),
                new Country("North Korea", "850"),
                new Country("Northern Mariana Islands", "1-670"),
                new Country("Norway", "47"),
                new Country("Oman", "968"),
                new Country("Pakistan", "92"),
                new Country("Palau", "680"),
                new Country("Palestine", "970"),
                new Country("Panama", "507"),
                new Country("Papua New Guinea", "675"),
                new Country("Paraguay", "595"),
                new Country("Peru", "51"),
                new Country("Philippines", "63"),
                new Country("Pitcairn", "64"),
                new Country("Poland", "48"),
                new Country("Portugal", "351"),
                new Country("Puerto Rico", new String[]{"1-787", "1-939"}),
                new Country("Qatar", "974"),
                new Country("Republic of the Congo", "242"),
                new Country("Reunion", "262"),
                new Country("Romania", "40"),
                new Country("Russia", "7"),
                new Country("Rwanda", "250"),
                new Country("Saint Barthelemy", "590"),
                new Country("Saint Helena", "290"),
                new Country("Saint Kitts and Nevis", "1-869"),
                new Country("Saint Lucia", "1-758"),
                new Country("Saint Martin", "590"),
                new Country("Saint Pierre and Miquelon", "508"),
                new Country("Saint Vincent and the Grenadines", "1-784"),
                new Country("Samoa", "685"),
                new Country("San Marino", "378"),
                new Country("Sao Tome and Principe", "239"),
                new Country("Saudi Arabia", "966"),
                new Country("Senegal", "221"),
                new Country("Serbia", "381"),
                new Country("Seychelles", "248"),
                new Country("Sierra Leone", "232"),
                new Country("Singapore", "65"),
                new Country("Sint Maarten", "1-721"),
                new Country("Slovakia", "421"),
                new Country("Slovenia", "386"),
                new Country("Solomon Islands", "677"),
                new Country("Somalia", "252"),
                new Country("South Africa", "27"),
                new Country("South Korea", "82"),
                new Country("South Sudan", "211"),
                new Country("Spain", "34"),
                new Country("Sri Lanka", "94"),
                new Country("Sudan", "249"),
                new Country("Suriname", "597"),
                new Country("Svalbard and Jan Mayen", "47"),
                new Country("Swaziland", "268"),
                new Country("Sweden", "46"),
                new Country("Switzerland", "41"),
                new Country("Syria", "963"),
                new Country("Taiwan", "886"),
                new Country("Tajikistan", "992"),
                new Country("Tanzania", "255"),
                new Country("Thailand", "66"),
                new Country("Togo", "228"),
                new Country("Tokelau", "690"),
                new Country("Tonga", "676"),
                new Country("U.S. Virgin Islands", "1-340"),
                new Country("Trinidad and Tobago", "1-868"),
                new Country("Tunisia", "216"),
                new Country("Turkey", "90"),
                new Country("Turkmenistan", "993"),
                new Country("Turks and Caicos Islands", "1-649"),
                new Country("Tuvalu", "688"),
                new Country("Uganda", "256"),
                new Country("Ukraine", "380"),
                new Country("United Arab Emirates", "971"),
                new Country("United Kingdom", "44"),
                new Country("United States", "1"),
                new Country("Uruguay", "598"),
                new Country("Uzbekistan", "998"),
                new Country("Vanuatu", "678"),
                new Country("Vatican", "379"),
                new Country("Venezuela", "58"),
                new Country("Vietnam", "84"),
                new Country("Wallis and Futuna", "681"),
                new Country("Western Sahara", "212"),
                new Country("Yemen", "967"),
                new Country("Zambia", "260"),
                new Country("Zimbabwe", "263"),
                new Country("Afghanistan", "93"),
                new Country("Albania", "355"),
                new Country("Algeria", "213"),
                new Country("American Samoa", "1-684"),
                new Country("Andorra", "376"),
                new Country("Angola", "244"),
                new Country("Anguilla", "1-264"),
                new Country("Antarctica", "672"),
                new Country("Antigua and Barbuda", "1-268"),
                new Country("Argentina", "54"),
                new Country("Armenia", "374"),
                new Country("Aruba", "297"),
                new Country("Australia", "61"),
                new Country("Austria", "43"),
                new Country("Azerbaijan", "994"),
                new Country("Bahamas", "1-242"),
                new Country("Bahrain", "973"),
                new Country("Bangladesh", "880"),
                new Country("Barbados", "1-246"),
                new Country("Belarus", "375"),
                new Country("Belgium", "32"),
                new Country("Belize", "501"),
                new Country("Benin", "229"),
                new Country("Bermuda", "1-441"),
                new Country("Bhutan", "975"),
                new Country("Bolivia", "591"),
                new Country("Bosnia and Herzegovina", "387"),
                new Country("Botswana", "267"),
                new Country("Brazil", "55"),
                new Country("British Indian Ocean Territory", "246"),
                new Country("British Virgin Islands", "1-284"),
                new Country("Brunei", "673"),
                new Country("Bulgaria", "359"),
                new Country("Burkina Faso", "226"),
                new Country("Burundi", "257"),
                new Country("Cambodia", "855"),
                new Country("Cameroon", "237"),
                new Country("Canada", "1"),
                new Country("Cape Verde", "238"),
                new Country("Cayman Islands", "1-345"),
                new Country("Central African Republic", "236"),
                new Country("Chad", "235"),
                new Country("Chile", "56"),
                new Country("China", "86"),
                new Country("Christmas Island", "61"),
                new Country("Cocos Islands", "61"),
                new Country("Colombia", "57"),
                new Country("Comoros", "269"),
                new Country("Cook Islands", "682"),
                new Country("Costa Rica", "506"),
                new Country("Croatia", "385"),
                new Country("Cuba", "53"),
                new Country("Curacao", "599"),
                new Country("Cyprus", "357"),
                new Country("Czech Republic", "420"),
                new Country("Democratic Republic of the Congo", "243"),
                new Country("Denmark", "45"),
                new Country("Djibouti", "253"),
                new Country("Dominica", "1-767"),
                new Country("Dominican Republic", new String[]{"1-809", "1-829", "1-849"}),
                new Country("East Timor", "670"),
                new Country("Ecuador", "593"),
                new Country("Egypt", "20"),
                new Country("El Salvador", "503"),
                new Country("Equatorial Guinea", "240"),
                new Country("Eritrea", "291"),
                new Country("Estonia", "372"),
                new Country("Ethiopia", "251"),
                new Country("Falkland Islands", "500"),
                new Country("Faroe Islands", "298"),
                new Country("Fiji", "679"),
                new Country("Finland", "358"),
                new Country("France", "33"),
                new Country("French Polynesia", "689"),
                new Country("Gabon", "241"),
                new Country("Gambia", "220"),
                new Country("Georgia", "995"),
                new Country("Germany", "49"),
                new Country("Ghana", "233"),
                new Country("Gibraltar", "350"),
                new Country("Greece", "30"),
                new Country("Greenland", "299"),
                new Country("Grenada", "1-473"),
                new Country("Guam", "1-671"),
                new Country("Guatemala", "502"),
                new Country("Guernsey", "44-1481"),
                new Country("Guinea", "224"),
                new Country("Guinea-Bissau", "245"),
                new Country("Guyana", "592"),
                new Country("Haiti", "509"),
                new Country("Honduras", "504"),
                new Country("Hong Kong", "852"),
                new Country("Hungary", "36"),
                new Country("Iceland", "354"),
                new Country("India", "91"),
                new Country("Indonesia", "62"),
                new Country("Iran", "98"),
                new Country("Iraq", "964"),
                new Country("Ireland", "353"),
                new Country("Isle of Man", "44-1624"),
                new Country("Israel", "972"),
                new Country("Italy", "39"),
                new Country("Ivory Coast", "225"),
                new Country("Jamaica", "1-876"),
                new Country("Japan", "81"),
                new Country("Jersey", "44-1534"),
                new Country("Jordan", "962"),
                new Country("Kazakhstan", "7"),
                new Country("Kenya", "254"),
                new Country("Kiribati", "686"),
                new Country("Kosovo", "383"),
                new Country("Kuwait", "965"),
                new Country("Kyrgyzstan", "996"),
                new Country("Laos", "856"),
                new Country("Latvia", "371"),
                new Country("Lebanon", "961"),
                new Country("Lesotho", "266"),
                new Country("Liberia", "231"),
                new Country("Libya", "218"),
                new Country("Liechtenstein", "423"),
                new Country("Lithuania", "370"),
                new Country("Luxembourg", "352"),
                new Country("Macau", "853"),
                new Country("Macedonia", "389"),
                new Country("Madagascar", "261"),
                new Country("Malawi", "265"),
                new Country("Malaysia", "60"),
                new Country("Maldives", "960"),
                new Country("Mali", "223"),
                new Country("Malta", "356"),
                new Country("Marshall Islands", "692"),
                new Country("Mauritania", "222"),
                new Country("Mauritius", "230"),
                new Country("Mayotte", "262"),
                new Country("Mexico", "52"),
                new Country("Micronesia", "691"),
                new Country("Moldova", "373"),
                new Country("Monaco", "377"),
                new Country("Mongolia", "976"),
                new Country("Montenegro", "382"),
                new Country("Montserrat", "1-664"),
                new Country("Morocco", "212"),
                new Country("Mozambique", "258"),
                new Country("Myanmar", "95"),
                new Country("Namibia", "264"),
                new Country("Nauru", "674"),
                new Country("Nepal", "977"),
                new Country("Netherlands", "31"),
                new Country("Netherlands Antilles", "599"),
                new Country("New Caledonia", "687"),
                new Country("New Zealand", "64"),
                new Country("Nicaragua", "505"),
                new Country("Niger", "227"),
                new Country("Nigeria", "234"),
                new Country("Niue", "683"),
                new Country("North Korea", "850"),
                new Country("Northern Mariana Islands", "1-670"),
                new Country("Norway", "47"),
                new Country("Oman", "968"),
                new Country("Pakistan", "92"),
                new Country("Palau", "680"),
                new Country("Palestine", "970"),
                new Country("Panama", "507"),
                new Country("Papua New Guinea", "675"),
                new Country("Paraguay", "595"),
                new Country("Peru", "51"),
                new Country("Philippines", "63"),
                new Country("Pitcairn", "64"),
                new Country("Poland", "48"),
                new Country("Portugal", "351"),
                new Country("Puerto Rico", new String[]{"1-787", "1-939"}),
                new Country("Qatar", "974"),
                new Country("Republic of the Congo", "242"),
                new Country("Reunion", "262"),
                new Country("Romania", "40"),
                new Country("Russia", "7"),
                new Country("Rwanda", "250"),
                new Country("Saint Barthelemy", "590"),
                new Country("Saint Helena", "290"),
                new Country("Saint Kitts and Nevis", "1-869"),
                new Country("Saint Lucia", "1-758"),
                new Country("Saint Martin", "590"),
                new Country("Saint Pierre and Miquelon", "508"),
                new Country("Saint Vincent and the Grenadines", "1-784"),
                new Country("Samoa", "685"),
                new Country("San Marino", "378"),
                new Country("Sao Tome and Principe", "239"),
                new Country("Saudi Arabia", "966"),
                new Country("Senegal", "221"),
                new Country("Serbia", "381"),
                new Country("Seychelles", "248"),
                new Country("Sierra Leone", "232"),
                new Country("Singapore", "65"),
                new Country("Sint Maarten", "1-721"),
                new Country("Slovakia", "421"),
                new Country("Slovenia", "386"),
                new Country("Solomon Islands", "677"),
                new Country("Somalia", "252"),
                new Country("South Africa", "27"),
                new Country("South Korea", "82"),
                new Country("South Sudan", "211"),
                new Country("Spain", "34"),
                new Country("Sri Lanka", "94"),
                new Country("Sudan", "249"),
                new Country("Suriname", "597"),
                new Country("Svalbard and Jan Mayen", "47"),
                new Country("Swaziland", "268"),
                new Country("Sweden", "46"),
                new Country("Switzerland", "41"),
                new Country("Syria", "963"),
                new Country("Taiwan", "886"),
                new Country("Tajikistan", "992"),
                new Country("Tanzania", "255"),
                new Country("Thailand", "66"),
                new Country("Togo", "228"),
                new Country("Tokelau", "690"),
                new Country("Tonga", "676"),
                new Country("U.S. Virgin Islands", "1-340"),
                new Country("Trinidad and Tobago", "1-868"),
                new Country("Tunisia", "216"),
                new Country("Turkey", "90"),
                new Country("Turkmenistan", "993"),
                new Country("Turks and Caicos Islands", "1-649"),
                new Country("Tuvalu", "688"),
                new Country("Uganda", "256"),
                new Country("Ukraine", "380"),
                new Country("United Arab Emirates", "971"),
                new Country("United Kingdom", "44"),
                new Country("United States", "1"),
                new Country("Uruguay", "598"),
                new Country("Uzbekistan", "998"),
                new Country("Vanuatu", "678"),
                new Country("Vatican", "379"),
                new Country("Venezuela", "58"),
                new Country("Vietnam", "84"),
                new Country("Wallis and Futuna", "681"),
                new Country("Western Sahara", "212"),
                new Country("Yemen", "967"),
                new Country("Zambia", "260"),
                new Country("Zimbabwe", "263"),
        };
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static boolean makeDirectory(String path) {
        File pDir = new File(path);
        boolean isDirectoryCreated = pDir.exists();
        if (!isDirectoryCreated)
            isDirectoryCreated = pDir.mkdir();
        if (isDirectoryCreated) return true;                //Write the file
        else throw new RuntimeException("Couldn't create the directory");
    }

    private static boolean mayAccessStorage(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(context, READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return true;
        //if (shouldShowRequestPermissionRationale((Activity) context, READ_EXTERNAL_STORAGE)) {
        requestPermissions((Activity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},
                REQUEST_STORAGE_ACCESS);
        //} else {
        //    requestPermissions((Activity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},
        // REQUEST_STORAGE_ACCESS);
        //}
        return false;
    }

    public static void saveFile(Context context, String path, StorageReference ref, final File file) {
        if (mayAccessStorage(context))
            if (Helper.isExternalStorageWritable() && Helper.makeDirectory(Helper.APP_FOLDER)
                    && Helper.makeDirectory(path)) {
                final long ONE_MEGABYTE = 1024 * 1024;
                ref.getBytes(ONE_MEGABYTE * 100).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        try {
                            FileOutputStream outputStream = new FileOutputStream(file);
                            outputStream.write(bytes);
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                    }
                });
            }
    }

    public static void saveVideo(Context context, String path, StorageReference ref,
                                 final File file, final VideoView videoView) {
        if (mayAccessStorage(context))
            if (Helper.isExternalStorageWritable() && Helper.makeDirectory(Helper.APP_FOLDER)
                    && Helper.makeDirectory(path)) {
                final long ONE_MEGABYTE = 1024 * 1024;
                ref.getBytes(ONE_MEGABYTE * 100).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        try {
                            FileOutputStream outputStream = new FileOutputStream(file);
                            outputStream.write(bytes);
                            outputStream.close();
                            videoView.setVideoPath(file.getPath());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                    }
                });
            }
    }

    //Environment.getExternalStorageDirectory(), ".pdf" for a full scan
    public ArrayList<File> searchFilesWithExtension(File dir, String pattern) {
        File listFile[] = dir.listFiles();
        ArrayList<File> list = new ArrayList<>();

        if (listFile != null)
            for (File aListFile : listFile) {
                if (aListFile.isDirectory()) searchFilesWithExtension(aListFile, pattern);
                else if (aListFile.getName().endsWith(pattern)) list.add(aListFile);
            }
        return list;
    }
}
