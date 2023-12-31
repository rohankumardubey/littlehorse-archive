package common

import (
	"fmt"
	"log"
	"reflect"
	"strconv"

	"github.com/littlehorse-enterprises/littlehorse/sdk-go/common/model"
	"github.com/ztrue/tracerr"
	"google.golang.org/protobuf/encoding/protojson"
	"google.golang.org/protobuf/proto"
)

func GetInputVarDefs(w *model.WfSpecPb) map[string]*model.VariableDefPb {
	// First, find the entrypoint threadspec
	tspec := w.ThreadSpecs[w.EntrypointThreadName]

	if tspec == nil {
		panic("Not possible.")
	}

	out := make(map[string]*model.VariableDefPb)

	for _, vd := range tspec.VariableDefs {
		out[vd.Name] = vd
	}

	return out
}

func GetWfRunIdFromTaskSource(source *model.TaskRunSourcePb) *string {
	switch s := source.TaskRunSource.(type) {
	case *model.TaskRunSourcePb_UserTaskTrigger:
		return &s.UserTaskTrigger.NodeRunId.WfRunId
	case *model.TaskRunSourcePb_TaskNode:
		return &s.TaskNode.NodeRunId.WfRunId
	}
	return nil
}

func PrintResp(resp proto.Message, err error) {
	if err != nil {
		tracerr.PrintSourceColor(err)
		fmt.Printf("Failed to connect: " + err.Error())
		log.Fatal(err)
	}

	b, err := protojson.MarshalOptions{
		Indent:          "  ",
		EmitUnpopulated: true,
	}.Marshal(resp)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(string(b))
}

func PrintProto(p proto.Message) {
	b, _ := protojson.MarshalOptions{
		Indent:          "  ",
		EmitUnpopulated: true,
	}.Marshal(p)
	fmt.Println(string(b))
}

func GetIsPtrAndType(thing reflect.Type) (bool, reflect.Kind) {
	if thing.Kind() == reflect.Ptr {
		return true, thing.Elem().Kind()
	} else {
		return false, thing.Kind()
	}
}

func formatInt32(n int32) string {
	return strconv.FormatInt(int64(n), 10)
}

func derefString(s *string) string {
	if s != nil {
		return *s
	}
	return ""
}
