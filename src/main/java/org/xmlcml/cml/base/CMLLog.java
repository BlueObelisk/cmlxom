/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.base;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/** generic logfile for CML activities
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class CMLLog implements CMLConstants {

    /** levels of warnings.
     * @author pm286
     */
    public enum Severity {
        /** warning */
        WARNING,
        /** error */
        ERROR,
        /** info */
        INFO,
        ;
        private Severity() {
        }
    }

    List<Message> messageList;
    /** constructor.
     */
    public CMLLog() {
        messageList = new ArrayList<Message>();
    }

    /** add string.
     * @param severity
     * @param s
     */
    public void add(Severity severity, String s) {
        messageList.add(new Message(severity, s));
    }

    /** add string.
     * 
     * @param s
     */
    public void add(String s) {
        messageList.add(new Message(s));
    }

    /** add error.
     * 
     * @param t 
     * @param s
     */
    public void add(Throwable t, String s) {
        messageList.add(new Message(t, s));
    }

    /** add file.
     * used when writing to file
     * @param file
     * @param s
     */
    public void add(File file, String s) {
        messageList.add(new Message(file, s));
    }

    /** output log.
     * 
     * @param w
     * @throws IOException
     */
    public void write(Writer w) throws IOException {
        for (Message m : messageList) {
            if (m.t != null) {
                w.write(m.t.toString()+": ");
            }
            w.write(m.s+"\n");
        }
    }
    
    /** output log.
     * 
     * @param w
     * @throws IOException
     */
    public void writeXML(Writer w) throws IOException {
        w.write("<log>\n");
        for (Message m : messageList) {
            m.writeXML(w);
        }
        w.write("</log>\n");
    }

}
class Message {

    CMLLog.Severity severity;
    File file;
    Throwable t;
    String s;
    
    /** constructor.
     * 
     * @param s message
     */
    public Message(String s) {
        this.s = s;
    }

    /** constructor.
     * @param sev severity level
     * @param s message
     */
    public Message(CMLLog.Severity sev, String s) {
        this.severity = sev;
        this.s = s;
    }

    /** constructor.
     * 
     * @param t
     * @param s message
     */
    public Message(Throwable t, String s) {
        this.t = t;
        this.s = s;
    }

    /** constructor.
     * 
     * @param file
     * @param s message
     */
    public Message(File file, String s) {
        this.file = file;
        this.s = s;
    }

    void writeXML(Writer w) throws IOException {
        if (t != null) {
            writeThrowable(w);
        } else if (file != null) {
            writeFile(w);
        } else {
            writeString(w);
        }
    }
    
    private void writeString(Writer w) throws IOException {
        if (s != null) {
            w.write("<string>"+s+"</string>\n");
        }
    }
    
    private void writeFile(Writer w) throws IOException {
        w.write("<file name='"+file.toString()+"'>");
        writeString(w);
        w.write("</file>\n");
    }
    
    private void writeThrowable(Writer w) throws IOException {
        w.write("<throw name='"+t.toString()+"'>");
        w.write(t.getMessage());
        writeString(w);
        w.write("</throw>\n");
    }
}
