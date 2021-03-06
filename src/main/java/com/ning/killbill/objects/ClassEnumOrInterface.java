package com.ning.killbill.objects;

import java.util.ArrayList;
import java.util.List;

public final class ClassEnumOrInterface {


    public enum ClassEnumOrInterfaceType {
        CLASS,
        INTERFACE,
        ENUM
    };

    private final String name;
    private final ClassEnumOrInterfaceType type;
    private final List<String> superInterfaces;
    protected final List<Annotation> annotations;

    private final String packageName;
    private String superBaseClass;

    private final boolean isAbstract;


    private final List<String> enumValues;
    private final List<MethodOrDecl> methodOrDecls;

    private final List<Field> fields;
    private final List<Constructor> ctors;


    public ClassEnumOrInterface(final String name, final ClassEnumOrInterfaceType type, final String packageName, final List<Annotation> annotations, final boolean anAbstract) {
        this.name = name;
        this.type = type;
        this.packageName = packageName;
        this.isAbstract = anAbstract;
        this.methodOrDecls = new ArrayList<MethodOrDecl>();
        this.ctors = new ArrayList<Constructor>();
        this.superInterfaces = new ArrayList<String>();
        this.superBaseClass = null;
        this.enumValues = new ArrayList<String>();
        this.fields = new ArrayList<Field>();
        this.annotations = annotations;
    }

    public void addConstructor(Constructor ctor) {
        ctors.add(ctor);
    }

    public void addMethod(MethodOrDecl method) {
        methodOrDecls.add(method);
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public void addSuperInterface(final String ifce) {
        superInterfaces.add(ifce);
    }

    public void addSuperClass(final String claz) {
        superBaseClass = claz;
    }

    public void addEnumValue(final String value) {
        enumValues.add(value);
    }

    public void addAnnotation(final Annotation annotation) {
        annotations.add(annotation);
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public String getName() {
        return name;
    }

    public boolean isInterface() {
        return type == ClassEnumOrInterfaceType.INTERFACE;
    }

    public boolean isClass() {
        return type == ClassEnumOrInterfaceType.CLASS;
    }

    public boolean isEnum() {
        return type == ClassEnumOrInterfaceType.ENUM;
    }

    public List<String> getEnumValues() {
        return enumValues;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<Constructor> getCtors() {
        return ctors;
    }

    public List<MethodOrDecl> getMethodOrDecls() {
        return methodOrDecls;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<String> getSuperInterfaces() {
        return superInterfaces;
    }

    public String getSuperBaseClass() {
        return superBaseClass;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public String getFullName() {
        return packageName + "." + name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassEnumOrInterface{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", abstract=").append(isAbstract);
        sb.append(", superInterfaces=").append(superInterfaces);
        sb.append(", superBaseClass='").append(superBaseClass).append('\'');
        sb.append(", enumValues=").append(enumValues);
        sb.append(", methodOrDecls=").append(methodOrDecls);
        sb.append(", fields=").append(fields);
        sb.append(", ctors=").append(ctors);
        sb.append('}');
        return sb.toString();
    }
}
