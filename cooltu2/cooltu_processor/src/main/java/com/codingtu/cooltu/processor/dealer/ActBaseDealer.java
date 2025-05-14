package com.codingtu.cooltu.processor.dealer;

import com.codingtu.cooltu.constant.FullName;
import com.codingtu.cooltu.constant.Pkg;
import com.codingtu.cooltu.lib4j.data.data.JavaInfo;
import com.codingtu.cooltu.lib4j.data.map.ListValueMap;
import com.codingtu.cooltu.lib4j.es.BaseEs;
import com.codingtu.cooltu.lib4j.es.Es;
import com.codingtu.cooltu.lib4j.es.map.BaseMaps;
import com.codingtu.cooltu.lib4j.tool.StringTool;
import com.codingtu.cooltu.lib4j.tool.TagTool;
import com.codingtu.cooltu.processor.deal.base.BaseDealer;
import com.codingtu.cooltu.processor.container.DealerMap;
import com.codingtu.cooltu.processor.tool.IdTool;
import com.codingtu.cooltu.processor.tool.LayoutTool;

public class ActBaseDealer extends BaseDealer {

    public String baseActivityClassFullName;
    public IdTool.Id layoutId;
    public LayoutTool.ViewInfo viewInfo;
    public BaseMaps<String, String> fieldMap = Es.maps();
    public BaseEs<String> findViewLines = Es.es();
    public ListValueMap<String, LayoutTool.ViewInfo> viewInfoMap = new ListValueMap<>();

    public ActBaseDealer(JavaInfo javaInfo) {
        super(javaInfo);
        DealerMap.putActBaseDealer(this);
    }

    @Override
    protected boolean isBuild() {
        return true;
    }

    @Override
    protected void beforeBuild() {
        super.beforeBuild();
//        lineEs.ls(new Es.EachEs<String>() {
//            @Override
//            public boolean each(int position, String line) {
//                Logs.i(line);
//                return false;
//            }
//        });
    }


    private LayoutTool.ViewInfo getParentViewInfo(LayoutTool.ViewInfo viewInfo) {
        while (true) {
            LayoutTool.ViewInfo parent = viewInfo.parent;
            if (parent != null) {
                if (StringTool.isNotBlank(parent.id)) {
                    return parent;
                } else {
                    viewInfo = parent;
                }
            } else {
                return null;
            }
        }
    }

    private void dealViewInfo(LayoutTool.ViewInfo viewInfo) {
        viewInfo.childs.ls(new Es.EachEs<LayoutTool.ViewInfo>() {
            @Override
            public boolean each(int position, LayoutTool.ViewInfo viewInfo) {
                if (StringTool.isNotBlank(viewInfo.id)) {
                    viewInfoMap.get(viewInfo.id).add(viewInfo);
                }
                dealViewInfo(viewInfo);
                return false;
            }
        });
    }

    @Override
    protected void dealLines() {
        super.dealLines();

        if (viewInfo != null) {
            if (StringTool.isBlank(viewInfo.id)) {
                fieldMap.put("rootViewGroup", "    protected android.view.ViewGroup rootViewGroup;");
                findViewLines.add(TagTool.dealLine("        rootViewGroup = [ViewTool].getRootViewGroup(this);", FullName.VIEW_TOOL));
            } else {
                fieldMap.put(viewInfo.id,
                        TagTool.dealLine("    protected [RelativeLayout] [rootRl];", LayoutTool.dealViewType(viewInfo.viewType), viewInfo.id));
                findViewLines.add(TagTool.dealLine("        [rootRl] = findViewById([com.codingtu.cooltu].R.id.[rootRl]);", viewInfo.id, Pkg.R, viewInfo.id));
            }

            dealViewInfo(viewInfo);
        }


        addLine("");
        addLine("public abstract class [ClassName]", javaInfo.name);
        addLine("        extends [BaseActivity]", baseActivityClassFullName);
        addLine("        implements");
        addLine("        android.view.View.OnClickListener,");
        addLine("        android.view.View.OnLongClickListener,");
        addLine("        [NetBackI] {", FullName.NET_BACK_I);
        addLine("    private String baseClassName = \"[ClassName]\";", javaInfo.name);

        fieldMap.ls(new Es.MapEach<String, String>() {
            @Override
            public boolean each(String fieldName, String fieldLine) {
                addLine(fieldLine);
                return false;
            }
        });


        addLine("");
        addLine("    @Override");
        addLine("    protected void onCreate(android.os.Bundle savedInstanceState) {");
        addLine("        super.onCreate(savedInstanceState);");
        if (layoutId != null && StringTool.isNotBlank(layoutId.rPackage)) {
            addLine("        setContentView([R.layout.activity_welcome]);", layoutId.toString());
        }

        findViewLines.ls(new Es.EachEs<String>() {
            @Override
            public boolean each(int position, String line) {
                addLine(line);
                return false;
            }
        });


        addLine("        String nowBaseClassName = getClass().getSimpleName() + [Suffix].ACT_BASE;", FullName.SUFFIX);
        addLine("        if (nowBaseClassName.equals(baseClassName)) {");
        addLine("            onCreateComplete();");
        addLine("        }");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public void onCreateComplete() {");
        addLine("        super.onCreateComplete();");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public void onClick(android.view.View view) {");
        addLine("");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public boolean onLongClick(android.view.View view) {");
        addLine("        return false;");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public void accept(String code,");
        addLine("                       retrofit2.adapter.rxjava2.Result<okhttp3.ResponseBody> result,");
        addLine("                       com.codingtu.cooltu.lib4a.net.bean.CoreSendParams params,");
        addLine("                       java.util.List objs) {");
        addLine("");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {");
        addLine("        super.onActivityResult(requestCode, resultCode, data);");
        addLine("        if (resultCode == android.app.Activity.RESULT_OK) {");
        addLine("");
        addLine("        }");
        addLine("    }");
        addLine("");
        addLine("    @Override");
        addLine("    public void back(int requestCode, String[] permissions, int[] grantResults) {");
        addLine("        super.back(requestCode, permissions, grantResults);");
        addLine("");
        addLine("    }");
        addLine("}");
    }

}
