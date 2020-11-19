/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import static org.passay.AllowedCharacterRule.ERROR_CODE;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

/**
 *
 * @author USER
 */
public class GeneratePasswordRandom {
    
    private static final int LENGHT_PASSWORD = 8;


    public static String passwordRandom() {
        final PasswordGenerator gen = new PasswordGenerator();
        final CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        final CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        final CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        final CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        final CharacterData digitChars = EnglishCharacterData.Digit;
        final CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        final CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);
        return gen.generatePassword(LENGHT_PASSWORD, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
    }

}
