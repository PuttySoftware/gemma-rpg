/*  Gemma: An RPG
 Copyright (C) 2013-2014 Eric Ahnell

 Any questions should be directed to the author via email at: support@puttysoftware.com
 */
package com.puttysoftware.gemma;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.xhtmlrenderer.swing.ScalableXHTMLPanel;

import com.puttysoftware.gemma.resourcemanagers.GraphicsConstants;
import com.puttysoftware.gemma.support.Support;
import com.puttysoftware.platform.Platform;

class ManualManager {
    // Fields
    private JFrame helpFrame;
    ScalableXHTMLPanel hv;
    private boolean inited;

    // Constructors
    public ManualManager() {
        this.inited = false;
    }

    // Methods
    void showHelp() {
        this.initHelp();
        this.helpFrame.setVisible(true);
    }

    private void initHelp() {
        if (!this.inited) {
            String title;
            if (Support.inDebugMode()) {
                title = "Gemma Manual (DEBUG)";
            } else {
                title = "Gemma Manual";
            }
            this.hv = new ScalableXHTMLPanel();
            try {
                this.hv.setDocument(ManualManager.class.getResourceAsStream(
                        "/com/puttysoftware/gemma/resources/help/manual.html"),
                        null);
            } catch (Exception e) {
                // Ignore
            }
            JScrollPane scroller = new JScrollPane(this.hv);
            this.hv.setPreferredSize(
                    new Dimension(GraphicsConstants.MAX_WINDOW_WIDTH,
                            GraphicsConstants.MAX_WINDOW_HEIGHT));
            scroller.setPreferredSize(
                    new Dimension(GraphicsConstants.MAX_WINDOW_WIDTH,
                            GraphicsConstants.MAX_WINDOW_HEIGHT));
            this.helpFrame = new JFrame(title);
            Platform.hookFrameIcon(this.helpFrame, Application.getIconLogo());
            this.helpFrame
                    .setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            this.helpFrame.setLayout(new BorderLayout());
            this.helpFrame.add(scroller, BorderLayout.CENTER);
            this.helpFrame.setResizable(false);
            this.helpFrame.pack();
            this.inited = true;
        }
    }
}
