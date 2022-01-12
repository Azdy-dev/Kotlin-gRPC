package me.test.grpc

import io.grpc.Server
import io.grpc.ServerBuilder
import java.io.IOException

class GrpcServer(port: Int) {
    private val server: Server

    companion object {
        private var grpcServer: GrpcServer? = null
        fun start(port: Int) {
            if (grpcServer == null) grpcServer = GrpcServer(port)
            try {
                grpcServer!!.server.start()
                println("GRPC server started")
                grpcServer!!.server.awaitTermination()
            } catch (e: IOException) {
                println("Can not start GRPC server")
            }
        }
    }

    init {
        server = ServerBuilder.forPort(port)
            .addService(StudentServiceImp())
            .intercept(GrpcServerInterceptor())
            .build()
    }
}