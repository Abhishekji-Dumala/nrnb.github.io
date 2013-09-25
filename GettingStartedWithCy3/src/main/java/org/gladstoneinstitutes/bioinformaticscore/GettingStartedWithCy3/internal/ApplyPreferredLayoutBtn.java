package org.gladstoneinstitutes.bioinformaticscore.GettingStartedWithCy3.internal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.net.URL;
import static org.cytoscape.work.ServiceProperties.*;
import org.cytoscape.view.model.CyNetworkView;
import java.util.Collections;

public class ApplyPreferredLayoutBtn extends JButton {
    public ApplyPreferredLayoutBtn() {
        super();

        final String iconUrl = (String) Services.preferredLayoutTFRef.getProperty(LARGE_ICON_URL);
        try {
            final ImageIcon icon = new ImageIcon(new URL(iconUrl));
            super.setIcon(icon);
        } catch (Exception e) {}

        super.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final CyNetworkView netView = Services.appMgr.getCurrentNetworkView();
                if (netView == null)
                    return;
                Services.taskMgr.execute(Services.preferredLayoutTF.createTaskIterator(Collections.singleton(netView)));
            }
        });
    }
}
