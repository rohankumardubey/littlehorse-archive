# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: lh_proto.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='lh_proto.proto',
  package='lh_proto',
  syntax='proto3',
  serialized_options=b'\n\033io.littlehorse.common.protoP\001Z\007.;model',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\x0elh_proto.proto\x12\x08lh_proto\"\x8f\x02\n\x0fVariableValuePb\x12&\n\x04type\x18\x01 \x01(\x0e\x32\x18.lh_proto.VariableTypePb\x12\x15\n\x08json_obj\x18\x02 \x01(\tH\x00\x88\x01\x01\x12\x15\n\x08json_arr\x18\x03 \x01(\tH\x01\x88\x01\x01\x12\x13\n\x06\x64ouble\x18\x04 \x01(\x01H\x02\x88\x01\x01\x12\x11\n\x04\x62ool\x18\x05 \x01(\x08H\x03\x88\x01\x01\x12\x10\n\x03str\x18\x06 \x01(\tH\x04\x88\x01\x01\x12\x10\n\x03int\x18\x07 \x01(\x05H\x05\x88\x01\x01\x12\x12\n\x05\x62ytes\x18\x08 \x01(\x0cH\x06\x88\x01\x01\x42\x0b\n\t_json_objB\x0b\n\t_json_arrB\t\n\x07_doubleB\x07\n\x05_boolB\x06\n\x04_strB\x06\n\x04_intB\x08\n\x06_bytes*Z\n\nLHStatusPb\x12\x0c\n\x08STARTING\x10\x00\x12\x0b\n\x07RUNNING\x10\x01\x12\r\n\tCOMPLETED\x10\x02\x12\x0b\n\x07HALTING\x10\x03\x12\n\n\x06HALTED\x10\x04\x12\t\n\x05\x45RROR\x10\x05*_\n\x0eVariableTypePb\x12\x0c\n\x08JSON_OBJ\x10\x00\x12\x0c\n\x08JSON_ARR\x10\x01\x12\n\n\x06\x44OUBLE\x10\x02\x12\x08\n\x04\x42OOL\x10\x03\x12\x07\n\x03STR\x10\x04\x12\x07\n\x03INT\x10\x05\x12\t\n\x05\x42YTES\x10\x06*>\n\x10TaskResultCodePb\x12\x0b\n\x07SUCCESS\x10\x00\x12\x0b\n\x07TIMEOUT\x10\x01\x12\x10\n\x0cTASK_FAILURE\x10\x02\x42(\n\x1bio.littlehorse.common.protoP\x01Z\x07.;modelb\x06proto3'
)

_LHSTATUSPB = _descriptor.EnumDescriptor(
  name='LHStatusPb',
  full_name='lh_proto.LHStatusPb',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='STARTING', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='RUNNING', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='COMPLETED', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='HALTING', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='HALTED', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='ERROR', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=302,
  serialized_end=392,
)
_sym_db.RegisterEnumDescriptor(_LHSTATUSPB)

LHStatusPb = enum_type_wrapper.EnumTypeWrapper(_LHSTATUSPB)
_VARIABLETYPEPB = _descriptor.EnumDescriptor(
  name='VariableTypePb',
  full_name='lh_proto.VariableTypePb',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='JSON_OBJ', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='JSON_ARR', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='DOUBLE', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='BOOL', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='STR', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='INT', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='BYTES', index=6, number=6,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=394,
  serialized_end=489,
)
_sym_db.RegisterEnumDescriptor(_VARIABLETYPEPB)

VariableTypePb = enum_type_wrapper.EnumTypeWrapper(_VARIABLETYPEPB)
_TASKRESULTCODEPB = _descriptor.EnumDescriptor(
  name='TaskResultCodePb',
  full_name='lh_proto.TaskResultCodePb',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='SUCCESS', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='TIMEOUT', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='TASK_FAILURE', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=491,
  serialized_end=553,
)
_sym_db.RegisterEnumDescriptor(_TASKRESULTCODEPB)

TaskResultCodePb = enum_type_wrapper.EnumTypeWrapper(_TASKRESULTCODEPB)
STARTING = 0
RUNNING = 1
COMPLETED = 2
HALTING = 3
HALTED = 4
ERROR = 5
JSON_OBJ = 0
JSON_ARR = 1
DOUBLE = 2
BOOL = 3
STR = 4
INT = 5
BYTES = 6
SUCCESS = 0
TIMEOUT = 1
TASK_FAILURE = 2



_VARIABLEVALUEPB = _descriptor.Descriptor(
  name='VariableValuePb',
  full_name='lh_proto.VariableValuePb',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='type', full_name='lh_proto.VariableValuePb.type', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='json_obj', full_name='lh_proto.VariableValuePb.json_obj', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='json_arr', full_name='lh_proto.VariableValuePb.json_arr', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='double', full_name='lh_proto.VariableValuePb.double', index=3,
      number=4, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='bool', full_name='lh_proto.VariableValuePb.bool', index=4,
      number=5, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='str', full_name='lh_proto.VariableValuePb.str', index=5,
      number=6, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='int', full_name='lh_proto.VariableValuePb.int', index=6,
      number=7, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='bytes', full_name='lh_proto.VariableValuePb.bytes', index=7,
      number=8, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=b"",
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
      name='_json_obj', full_name='lh_proto.VariableValuePb._json_obj',
      index=0, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_json_arr', full_name='lh_proto.VariableValuePb._json_arr',
      index=1, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_double', full_name='lh_proto.VariableValuePb._double',
      index=2, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_bool', full_name='lh_proto.VariableValuePb._bool',
      index=3, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_str', full_name='lh_proto.VariableValuePb._str',
      index=4, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_int', full_name='lh_proto.VariableValuePb._int',
      index=5, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
    _descriptor.OneofDescriptor(
      name='_bytes', full_name='lh_proto.VariableValuePb._bytes',
      index=6, containing_type=None,
      create_key=_descriptor._internal_create_key,
    fields=[]),
  ],
  serialized_start=29,
  serialized_end=300,
)

_VARIABLEVALUEPB.fields_by_name['type'].enum_type = _VARIABLETYPEPB
_VARIABLEVALUEPB.oneofs_by_name['_json_obj'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['json_obj'])
_VARIABLEVALUEPB.fields_by_name['json_obj'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_json_obj']
_VARIABLEVALUEPB.oneofs_by_name['_json_arr'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['json_arr'])
_VARIABLEVALUEPB.fields_by_name['json_arr'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_json_arr']
_VARIABLEVALUEPB.oneofs_by_name['_double'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['double'])
_VARIABLEVALUEPB.fields_by_name['double'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_double']
_VARIABLEVALUEPB.oneofs_by_name['_bool'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['bool'])
_VARIABLEVALUEPB.fields_by_name['bool'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_bool']
_VARIABLEVALUEPB.oneofs_by_name['_str'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['str'])
_VARIABLEVALUEPB.fields_by_name['str'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_str']
_VARIABLEVALUEPB.oneofs_by_name['_int'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['int'])
_VARIABLEVALUEPB.fields_by_name['int'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_int']
_VARIABLEVALUEPB.oneofs_by_name['_bytes'].fields.append(
  _VARIABLEVALUEPB.fields_by_name['bytes'])
_VARIABLEVALUEPB.fields_by_name['bytes'].containing_oneof = _VARIABLEVALUEPB.oneofs_by_name['_bytes']
DESCRIPTOR.message_types_by_name['VariableValuePb'] = _VARIABLEVALUEPB
DESCRIPTOR.enum_types_by_name['LHStatusPb'] = _LHSTATUSPB
DESCRIPTOR.enum_types_by_name['VariableTypePb'] = _VARIABLETYPEPB
DESCRIPTOR.enum_types_by_name['TaskResultCodePb'] = _TASKRESULTCODEPB
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

VariableValuePb = _reflection.GeneratedProtocolMessageType('VariableValuePb', (_message.Message,), {
  'DESCRIPTOR' : _VARIABLEVALUEPB,
  '__module__' : 'lh_proto_pb2'
  # @@protoc_insertion_point(class_scope:lh_proto.VariableValuePb)
  })
_sym_db.RegisterMessage(VariableValuePb)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)
