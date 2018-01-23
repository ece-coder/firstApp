package com.example.jibong.myapplication;

import com.joanzapata.iconify.Icon;

/**
 * Created by jibong on 12/12/2017.
 */

public enum AppFontIcons implements Icon {

    apfi_blog('a'),
    apfi_chat('b'),
    apfi_close('c'),
    apfi_contest('d'),
    apfi_down('e'),
    apfi_events('f'),
    apfi_join('g'),
    apfi_left('h'),
    apfi_location('i'),
    apfi_message('j'),
    apfi_notification_all('k'),
    apfi_notification_connected('l'),
    apfi_pause('m'),
    apfi_play('n'),
    apfi_plus('o'),
    apfi_profile('p'),
    apfi_right('q'),
    apfi_schedules('r'),
    apfi_more('s'),
    apfi_music('t'),
    apfi_notification('u');

    char character;

    AppFontIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
