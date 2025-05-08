package com.codingtu.cooltu.processor.deal.base;

import com.codingtu.cooltu.lib4j.data.data.JavaInfo;
import com.codingtu.cooltu.lib4j.es.BaseEs;
import com.codingtu.cooltu.lib4j.es.Es;
import com.codingtu.cooltu.lib4j.file.write.FileWriter;
import com.codingtu.cooltu.lib4j.tool.CountTool;
import com.codingtu.cooltu.lib4j.tool.TagTool;
import com.codingtu.cooltu.processor.tool.DealerMap;
import com.codingtu.cooltu.processor.tool.Logs;

import java.io.File;
import java.util.List;

public class BaseDealer {

    public JavaInfo javaInfo;
    protected BaseEs<String> lineEs;

    public BaseDealer(JavaInfo javaInfo) {
        this.javaInfo = javaInfo;
        DealerMap.put(this);
    }


    protected boolean isGetLines() {
        return true;
    }

    protected boolean isBuild() {
        return true;
    }

    protected boolean isForce() {
        return true;
    }

    public void create() {
        if (javaInfo == null) {
            return;
        }
        Logs.i(javaInfo.path);
        File file = new File(javaInfo.path);
        if (isGetLines() && (isForce() || !file.exists())) {
            getLines();
            beforeBuild();
            if (isBuild() && !lineEs.isNull()) {
                FileWriter.to(file).cover().write(lineEs);
            }
        }
    }

    protected void getLines() {
        lineEs = Es.es();
        dealLines();
    }

    protected void dealLines() {
        addLine("package [pkg];", javaInfo.pkg);
    }

    protected void beforeBuild() {
    }

    protected void addLine(String line, Object... objs) {
        lineEs.add(TagTool.dealLine(line, objs));
    }
}
