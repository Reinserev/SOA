// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Labels.proto

package com.ubb.pcis2083.soa.labels;

public final class Labels {
  private Labels() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ubb_pcis2083_soa_labels_Label_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ubb_pcis2083_soa_labels_Label_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ubb_pcis2083_soa_labels_LabelResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ubb_pcis2083_soa_labels_LabelResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Labels.proto\022\033com.ubb.pcis2083.soa.lab" +
      "els\032\033google/protobuf/empty.proto\032\036google" +
      "/protobuf/wrappers.proto\"!\n\005Label\022\n\n\002id\030" +
      "\001 \001(\003\022\014\n\004name\030\002 \001(\t\"C\n\rLabelResponse\0222\n\006" +
      "labels\030\001 \003(\0132\".com.ubb.pcis2083.soa.labe" +
      "ls.Label2\202\003\n\014LabelService\022L\n\006getAll\022\026.go" +
      "ogle.protobuf.Empty\032*.com.ubb.pcis2083.s" +
      "oa.labels.LabelResponse\022J\n\007getById\022\033.goo" +
      "gle.protobuf.Int64Value\032\".com.ubb.pcis20" +
      "83.soa.labels.Label\022G\n\004save\022\".com.ubb.pc",
      "is2083.soa.labels.Label\032\033.google.protobu" +
      "f.Int64Value\022H\n\006update\022\".com.ubb.pcis208" +
      "3.soa.labels.Label\032\032.google.protobuf.Boo" +
      "lValue\022E\n\ndeleteById\022\033.google.protobuf.I" +
      "nt64Value\032\032.google.protobuf.BoolValueB\002P" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        }, assigner);
    internal_static_com_ubb_pcis2083_soa_labels_Label_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ubb_pcis2083_soa_labels_Label_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ubb_pcis2083_soa_labels_Label_descriptor,
        new java.lang.String[] { "Id", "Name", });
    internal_static_com_ubb_pcis2083_soa_labels_LabelResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ubb_pcis2083_soa_labels_LabelResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ubb_pcis2083_soa_labels_LabelResponse_descriptor,
        new java.lang.String[] { "Labels", });
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
