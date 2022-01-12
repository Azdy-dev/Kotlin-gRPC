package me.test.grpc

import io.grpc.Server
import io.grpc.ServerBuilder
import java.io.IOException


fun main(args: Array<String>) {
    GrpcServer.start(6565)
}

