# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: observability.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import timestamp_pb2 as google_dot_protobuf_dot_timestamp__pb2
import lh_proto_pb2 as lh__proto__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='observability.proto',
  package='lh_proto',
  syntax='proto3',
  serialized_options=b'\n)io.littlehorse.common.proto.observabilityP\001Z\007.;model',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\x13observability.proto\x12\x08lh_proto\x1a\x1fgoogle/protobuf/timestamp.proto\x1a\x0elh_proto.proto\"8\n\x0cRunStartOePb\x12\x12\n\nwf_spec_id\x18\x01 \x01(\t\x12\x14\n\x0cwf_spec_name\x18\x02 \x01(\t\";\n\x0fThreadStartOePb\x12\x0e\n\x06number\x18\x01 \x01(\x05\x12\x18\n\x10thread_spec_name\x18\x02 \x01(\t\"\xbe\x01\n\x11TaskScheduledOePb\x12\x13\n\x0btask_def_id\x18\x01 \x01(\t\x12\x19\n\x11thread_run_number\x18\x02 \x01(\x05\x12\x17\n\x0ftask_run_number\x18\x03 \x01(\x05\x12\x19\n\x11task_run_position\x18\x04 \x01(\x05\x12\x1f\n\x17task_run_attempt_number\x18\x05 \x01(\x05\x12\x11\n\twf_run_id\x18\x06 \x01(\t\x12\x11\n\tnode_name\x18\x07 \x01(\t\"q\n\rTaskStartOePb\x12\x19\n\x11thread_run_number\x18\x01 \x01(\x05\x12\x17\n\x0ftask_run_number\x18\x02 \x01(\x05\x12\x19\n\x11task_run_position\x18\x03 \x01(\x05\x12\x11\n\tnode_name\x18\x04 \x01(\t\"\xeb\x01\n\x0eTaskResultOePb\x12\x19\n\x11thread_run_number\x18\x01 \x01(\x05\x12\x17\n\x0ftask_run_number\x18\x02 \x01(\x05\x12\x19\n\x11task_run_position\x18\x03 \x01(\x05\x12/\n\x0bresult_code\x18\x04 \x01(\x0e\x32\x1a.lh_proto.TaskResultCodePb\x12\x13\n\x06output\x18\x05 \x01(\x0cH\x00\x88\x01\x01\x12\x17\n\nlog_output\x18\x06 \x01(\x0cH\x01\x88\x01\x01\x12\x11\n\tnode_name\x18\x07 \x01(\tB\t\n\x07_outputB\r\n\x0b_log_output\"Y\n\x16ThreadStatusChangeOePb\x12\x19\n\x11thread_run_number\x18\x01 \x01(\x05\x12$\n\x06status\x18\x02 \x01(\x0e\x32\x14.lh_proto.LHStatusPb\"=\n\x15WfRunStatusChangeOePb\x12$\n\x06status\x18\x01 \x01(\x0e\x32\x14.lh_proto.LHStatusPb\"\xb4\x03\n\x14ObservabilityEventPb\x12(\n\x04time\x18\x01 \x01(\x0b\x32\x1a.google.protobuf.Timestamp\x12\x38\n\rwf_run_status\x18\x02 \x01(\x0b\x32\x1f.lh_proto.WfRunStatusChangeOePbH\x00\x12+\n\trun_start\x18\x03 \x01(\x0b\x32\x16.lh_proto.RunStartOePbH\x00\x12\x31\n\x0cthread_start\x18\x04 \x01(\x0b\x32\x19.lh_proto.ThreadStartOePbH\x00\x12\x34\n\rtask_schedule\x18\x05 \x01(\x0b\x32\x1b.lh_proto.TaskScheduledOePbH\x00\x12-\n\ntask_start\x18\x06 \x01(\x0b\x32\x17.lh_proto.TaskStartOePbH\x00\x12/\n\x0btask_result\x18\x07 \x01(\x0b\x32\x18.lh_proto.TaskResultOePbH\x00\x12\x39\n\rthread_status\x18\x08 \x01(\x0b\x32 .lh_proto.ThreadStatusChangeOePbH\x00\x42\x07\n\x05\x65vent\"Z\n\x15ObservabilityEventsPb\x12\x11\n\twf_run_id\x18\x01 \x01(\t\x12.\n\x06\x65vents\x18\x02 \x03(\x0b\x32\x1e.lh_proto.ObservabilityEventPbB6\n)io.littlehorse.common.proto.observabilityP\x01Z\x07.;modelb\x06proto3'
  ,
  dependencies=[google_dot_protobuf_dot_timestamp__pb2.DESCRIPTOR,lh__proto__pb2.DESCRIPTOR,])




_RUNSTARTOEPB = _descriptor.Descriptor(
  name='RunStartOePb',
  full_name='lh_proto.RunStartOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='wf_spec_id', full_name='lh_proto.RunStartOePb.wf_spec_id', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='wf_spec_name', full_name='lh_proto.RunStartOePb.wf_spec_name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=82,
  serialized_end=138,
)


_THREADSTARTOEPB = _descriptor.Descriptor(
  name='ThreadStartOePb',
  full_name='lh_proto.ThreadStartOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='number', full_name='lh_proto.ThreadStartOePb.number', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='thread_spec_name', full_name='lh_proto.ThreadStartOePb.thread_spec_name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=140,
  serialized_end=199,
)


_TASKSCHEDULEDOEPB = _descriptor.Descriptor(
  name='TaskScheduledOePb',
  full_name='lh_proto.TaskScheduledOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='task_def_id', full_name='lh_proto.TaskScheduledOePb.task_def_id', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='thread_run_number', full_name='lh_proto.TaskScheduledOePb.thread_run_number', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_number', full_name='lh_proto.TaskScheduledOePb.task_run_number', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_position', full_name='lh_proto.TaskScheduledOePb.task_run_position', index=3,
      number=4, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_attempt_number', full_name='lh_proto.TaskScheduledOePb.task_run_attempt_number', index=4,
      number=5, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='wf_run_id', full_name='lh_proto.TaskScheduledOePb.wf_run_id', index=5,
      number=6, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='node_name', full_name='lh_proto.TaskScheduledOePb.node_name', index=6,
      number=7, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=202,
  serialized_end=392,
)


_TASKSTARTOEPB = _descriptor.Descriptor(
  name='TaskStartOePb',
  full_name='lh_proto.TaskStartOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='thread_run_number', full_name='lh_proto.TaskStartOePb.thread_run_number', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_number', full_name='lh_proto.TaskStartOePb.task_run_number', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_position', full_name='lh_proto.TaskStartOePb.task_run_position', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='node_name', full_name='lh_proto.TaskStartOePb.node_name', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=394,
  serialized_end=507,
)


_TASKRESULTOEPB = _descriptor.Descriptor(
  name='TaskResultOePb',
  full_name='lh_proto.TaskResultOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='thread_run_number', full_name='lh_proto.TaskResultOePb.thread_run_number', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_number', full_name='lh_proto.TaskResultOePb.task_run_number', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_run_position', full_name='lh_proto.TaskResultOePb.task_run_position', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='result_code', full_name='lh_proto.TaskResultOePb.result_code', index=3,
      number=4, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='output', full_name='lh_proto.TaskResultOePb.output', index=4,
      number=5, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=b"",
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='log_output', full_name='lh_proto.TaskResultOePb.log_output', index=5,
      number=6, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=b"",
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='node_name', full_name='lh_proto.TaskResultOePb.node_name', index=6,
      number=7, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
    _descriptor.OneofDescriptor(
      name='_output', full_name='lh_proto.TaskResultOePb._output',
      index=0, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_log_output', full_name='lh_proto.TaskResultOePb._log_output',
      index=1, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
  ],
  serialized_start=510,
  serialized_end=745,
)


_THREADSTATUSCHANGEOEPB = _descriptor.Descriptor(
  name='ThreadStatusChangeOePb',
  full_name='lh_proto.ThreadStatusChangeOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='thread_run_number', full_name='lh_proto.ThreadStatusChangeOePb.thread_run_number', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='status', full_name='lh_proto.ThreadStatusChangeOePb.status', index=1,
      number=2, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=747,
  serialized_end=836,
)


_WFRUNSTATUSCHANGEOEPB = _descriptor.Descriptor(
  name='WfRunStatusChangeOePb',
  full_name='lh_proto.WfRunStatusChangeOePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='status', full_name='lh_proto.WfRunStatusChangeOePb.status', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=838,
  serialized_end=899,
)


_OBSERVABILITYEVENTPB = _descriptor.Descriptor(
  name='ObservabilityEventPb',
  full_name='lh_proto.ObservabilityEventPb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='time', full_name='lh_proto.ObservabilityEventPb.time', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='wf_run_status', full_name='lh_proto.ObservabilityEventPb.wf_run_status', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='run_start', full_name='lh_proto.ObservabilityEventPb.run_start', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='thread_start', full_name='lh_proto.ObservabilityEventPb.thread_start', index=3,
      number=4, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_schedule', full_name='lh_proto.ObservabilityEventPb.task_schedule', index=4,
      number=5, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_start', full_name='lh_proto.ObservabilityEventPb.task_start', index=5,
      number=6, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='task_result', full_name='lh_proto.ObservabilityEventPb.task_result', index=6,
      number=7, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='thread_status', full_name='lh_proto.ObservabilityEventPb.thread_status', index=7,
      number=8, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
    _descriptor.OneofDescriptor(
      name='event', full_name='lh_proto.ObservabilityEventPb.event',
      index=0, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
  ],
  serialized_start=902,
  serialized_end=1338,
)


_OBSERVABILITYEVENTSPB = _descriptor.Descriptor(
  name='ObservabilityEventsPb',
  full_name='lh_proto.ObservabilityEventsPb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='wf_run_id', full_name='lh_proto.ObservabilityEventsPb.wf_run_id', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='events', full_name='lh_proto.ObservabilityEventsPb.events', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=1340,
  serialized_end=1430,
)

_TASKRESULTOEPB.fields_by_name['result_code'].enum_type = lh__proto__pb2._TASKRESULTCODEPB
_TASKRESULTOEPB.oneofs_by_name['_output'].fields.append(
  _TASKRESULTOEPB.fields_by_name['output'])
_TASKRESULTOEPB.fields_by_name['output'].containing_oneof = _TASKRESULTOEPB.oneofs_by_name['_output']
_TASKRESULTOEPB.oneofs_by_name['_log_output'].fields.append(
  _TASKRESULTOEPB.fields_by_name['log_output'])
_TASKRESULTOEPB.fields_by_name['log_output'].containing_oneof = _TASKRESULTOEPB.oneofs_by_name['_log_output']
_THREADSTATUSCHANGEOEPB.fields_by_name['status'].enum_type = lh__proto__pb2._LHSTATUSPB
_WFRUNSTATUSCHANGEOEPB.fields_by_name['status'].enum_type = lh__proto__pb2._LHSTATUSPB
_OBSERVABILITYEVENTPB.fields_by_name['time'].message_type = google_dot_protobuf_dot_timestamp__pb2._TIMESTAMP
_OBSERVABILITYEVENTPB.fields_by_name['wf_run_status'].message_type = _WFRUNSTATUSCHANGEOEPB
_OBSERVABILITYEVENTPB.fields_by_name['run_start'].message_type = _RUNSTARTOEPB
_OBSERVABILITYEVENTPB.fields_by_name['thread_start'].message_type = _THREADSTARTOEPB
_OBSERVABILITYEVENTPB.fields_by_name['task_schedule'].message_type = _TASKSCHEDULEDOEPB
_OBSERVABILITYEVENTPB.fields_by_name['task_start'].message_type = _TASKSTARTOEPB
_OBSERVABILITYEVENTPB.fields_by_name['task_result'].message_type = _TASKRESULTOEPB
_OBSERVABILITYEVENTPB.fields_by_name['thread_status'].message_type = _THREADSTATUSCHANGEOEPB
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['wf_run_status'])
_OBSERVABILITYEVENTPB.fields_by_name['wf_run_status'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['run_start'])
_OBSERVABILITYEVENTPB.fields_by_name['run_start'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['thread_start'])
_OBSERVABILITYEVENTPB.fields_by_name['thread_start'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['task_schedule'])
_OBSERVABILITYEVENTPB.fields_by_name['task_schedule'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['task_start'])
_OBSERVABILITYEVENTPB.fields_by_name['task_start'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['task_result'])
_OBSERVABILITYEVENTPB.fields_by_name['task_result'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTPB.oneofs_by_name['event'].fields.append(
  _OBSERVABILITYEVENTPB.fields_by_name['thread_status'])
_OBSERVABILITYEVENTPB.fields_by_name['thread_status'].containing_oneof = _OBSERVABILITYEVENTPB.oneofs_by_name['event']
_OBSERVABILITYEVENTSPB.fields_by_name['events'].message_type = _OBSERVABILITYEVENTPB
DESCRIPTOR.message_types_by_name['RunStartOePb'] = _RUNSTARTOEPB
DESCRIPTOR.message_types_by_name['ThreadStartOePb'] = _THREADSTARTOEPB
DESCRIPTOR.message_types_by_name['TaskScheduledOePb'] = _TASKSCHEDULEDOEPB
DESCRIPTOR.message_types_by_name['TaskStartOePb'] = _TASKSTARTOEPB
DESCRIPTOR.message_types_by_name['TaskResultOePb'] = _TASKRESULTOEPB
DESCRIPTOR.message_types_by_name['ThreadStatusChangeOePb'] = _THREADSTATUSCHANGEOEPB
DESCRIPTOR.message_types_by_name['WfRunStatusChangeOePb'] = _WFRUNSTATUSCHANGEOEPB
DESCRIPTOR.message_types_by_name['ObservabilityEventPb'] = _OBSERVABILITYEVENTPB
DESCRIPTOR.message_types_by_name['ObservabilityEventsPb'] = _OBSERVABILITYEVENTSPB
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

RunStartOePb = _reflection.GeneratedProtocolMessageType('RunStartOePb', (_message.Message,), {
  'DESCRIPTOR' : _RUNSTARTOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.RunStartOePb)
  })
_sym_db.RegisterMessage(RunStartOePb)

ThreadStartOePb = _reflection.GeneratedProtocolMessageType('ThreadStartOePb', (_message.Message,), {
  'DESCRIPTOR' : _THREADSTARTOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.ThreadStartOePb)
  })
_sym_db.RegisterMessage(ThreadStartOePb)

TaskScheduledOePb = _reflection.GeneratedProtocolMessageType('TaskScheduledOePb', (_message.Message,), {
  'DESCRIPTOR' : _TASKSCHEDULEDOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.TaskScheduledOePb)
  })
_sym_db.RegisterMessage(TaskScheduledOePb)

TaskStartOePb = _reflection.GeneratedProtocolMessageType('TaskStartOePb', (_message.Message,), {
  'DESCRIPTOR' : _TASKSTARTOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.TaskStartOePb)
  })
_sym_db.RegisterMessage(TaskStartOePb)

TaskResultOePb = _reflection.GeneratedProtocolMessageType('TaskResultOePb', (_message.Message,), {
  'DESCRIPTOR' : _TASKRESULTOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.TaskResultOePb)
  })
_sym_db.RegisterMessage(TaskResultOePb)

ThreadStatusChangeOePb = _reflection.GeneratedProtocolMessageType('ThreadStatusChangeOePb', (_message.Message,), {
  'DESCRIPTOR' : _THREADSTATUSCHANGEOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.ThreadStatusChangeOePb)
  })
_sym_db.RegisterMessage(ThreadStatusChangeOePb)

WfRunStatusChangeOePb = _reflection.GeneratedProtocolMessageType('WfRunStatusChangeOePb', (_message.Message,), {
  'DESCRIPTOR' : _WFRUNSTATUSCHANGEOEPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.WfRunStatusChangeOePb)
  })
_sym_db.RegisterMessage(WfRunStatusChangeOePb)

ObservabilityEventPb = _reflection.GeneratedProtocolMessageType('ObservabilityEventPb', (_message.Message,), {
  'DESCRIPTOR' : _OBSERVABILITYEVENTPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.ObservabilityEventPb)
  })
_sym_db.RegisterMessage(ObservabilityEventPb)

ObservabilityEventsPb = _reflection.GeneratedProtocolMessageType('ObservabilityEventsPb', (_message.Message,), {
  'DESCRIPTOR' : _OBSERVABILITYEVENTSPB,
  '__module__' : 'observability_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.ObservabilityEventsPb)
  })
_sym_db.RegisterMessage(ObservabilityEventsPb)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)
