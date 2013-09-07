package net.solutinno.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SpeechHelper
{
    private static Context mContext;
    private static final Map<String, Locale> mLanguages = new HashMap<String, Locale>();
    private static boolean mIsInitialised;

    public static void initialise(Context context) {
        mContext = context;
        mIsInitialised = false;
        initLanguages();
    }

    private static void initLanguages() {
        Intent intent = new Intent(RecognizerIntent.ACTION_GET_LANGUAGE_DETAILS);
        mContext.sendOrderedBroadcast(intent, null, mReceiver, null, Activity.RESULT_OK, null, null);
    }

    private static BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = getResultExtras(true);
            assert extras != null;
            if (extras.containsKey(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES)) {
                List<String> languages = extras.getStringArrayList(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);
                assert languages != null;
                for (String lang : languages) {
                    String[] loc = Iterables.toArray(Splitter.on('-').split(lang), String.class);
                    if (loc.length == 3) mLanguages.put(lang, new Locale(loc[0], loc[1], loc[2]));
                    else if (loc.length == 2) mLanguages.put(lang, new Locale(loc[0], loc[1]));
                    else if (loc.length == 1) mLanguages.put(lang, new Locale(loc[0]));
                }
            }
            mIsInitialised = true;
        }
    };

    public static Map<String, Locale> getLanguages() {
        return Maps.newHashMap(mLanguages);
    }

    public static boolean startSpeechRecognition(Fragment fragment, int requestCode, String language) {
        if (!mIsInitialised) return false;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        fragment.startActivityForResult(intent, requestCode);
        return true;
    }

    public static List<String> getRecognisedWords(Intent data) {
        return mIsInitialised ? data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) : new ArrayList<String>();
    }
}
