package com.jmoiron.ulvcovm.data;

import com.jmoiron.ulvcovm.data.lang.LangHandler;
import com.jmoiron.ulvcovm.registry.UCMRegistries;
import com.tterrag.registrate.providers.ProviderType;

public class UCMDatagen {
    public static void init() {
        UCMRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
