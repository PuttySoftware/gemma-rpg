/*  Gemma: An RPG
 Copyright (C) 2013-2014 Eric Ahnell


 Any questions should be directed to the author via email at: support@puttysoftware.com
 */
package com.puttysoftware.gemma.support.descriptionmanagers;

import com.puttysoftware.gemma.support.creatures.races.RaceConstants;
import com.puttysoftware.gemma.support.scenario.Extension;
import com.puttysoftware.xio.ResourceStreamReader;

public class RaceDescriptionManager {
    public static String getRaceDescription(final int r) {
        String name = RaceConstants.getRaceName(r).toLowerCase();
        try (final ResourceStreamReader rsr = new ResourceStreamReader(
                RaceDescriptionManager.class.getResourceAsStream(
                        "/com/puttysoftware/gemma/support/resources/descriptions/race/"
                                + name + Extension
                                        .getDescriptionExtensionWithPeriod()))) {
            // Fetch description
            String desc = rsr.readString();
            rsr.close();
            return desc;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
