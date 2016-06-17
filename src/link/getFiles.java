/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package link;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
/**
 *
 * @author Rakha Agung trimanda
 */
public class getFiles {
    class AnOvalIcon implements Icon {
        Color color;

        public AnOvalIcon(Color c) {
          color = c;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
          g.setColor(color);
          g.fillOval(x, y, getIconWidth(), getIconHeight());
        }

        public int getIconWidth() {
          return 10;
        }

        public int getIconHeight() {
          return 15;
        }
      }

      public class IconView extends FileView {
        private HashMap hash = new HashMap();

        public IconView() {
          hash.put("htm", new AnOvalIcon(Color.RED));
          hash.put("html", new AnOvalIcon(Color.GREEN));
          hash.put("java", new AnOvalIcon(Color.BLUE));
        }

        public String getName(File f) {
          String s = f.getName();
          if (s.length() == 0) {
            s = f.getAbsolutePath();
          }
          return s;
        }

        public String getDescription(File f) {
          return f.getName();
        }

        public String getTypeDescription(File f) {
          return f.getAbsolutePath();
        }

        public Icon getIcon(File f) {
          String path = f.getAbsolutePath();
          int pos = path.lastIndexOf('.');
          if ((pos >= 0) && (pos < (path.length() - 1))) {
            String ext = path.substring(pos + 1).toLowerCase();
            return (Icon) hash.get(ext);
          }
          return null;
        }

        public Boolean isTraversable(File file) {
          return (new Boolean(file.isDirectory()));
        }
      }

      public class ExtensionFilter extends FileFilter {
        private String extensions[];

        private String description;

        public ExtensionFilter(String description, String extension) {
          this(description, new String[] { extension });
        }

        public ExtensionFilter(String description, String extensions[]) {
          this.description = description;
          this.extensions = (String[]) extensions.clone();
        }

        public boolean accept(File file) {
          if (file.isDirectory()) {
            return true;
          }
          int count = extensions.length;
          String path = file.getAbsolutePath();
          for (int i = 0; i < count; i++) {
            String ext = extensions[i];
            if (path.endsWith(ext)
                && (path.charAt(path.length() - ext.length()) == '.')) {
              return true;
            }
          }
          return false;
        }

        public String getDescription() {
          return (description == null ? extensions[0] : description);
        }
      }

}
