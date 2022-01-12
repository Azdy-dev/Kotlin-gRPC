package me.test.grpc

import io.grpc.*
import mu.KotlinLogging

class GrpcServerInterceptor : ServerInterceptor {
    companion object {
        val logger = KotlinLogging.logger { }
    }

    override fun <ReqT : Any?, RespT : Any?> interceptCall(
        serverCall: ServerCall<ReqT, RespT>?,
        metadata: Metadata?,
        serverCallHandler: ServerCallHandler<ReqT, RespT>?
    ): ServerCall.Listener<ReqT> {
        logger.info { "Metadata: $metadata" }
        return Contexts.interceptCall(Context.current(), serverCall, metadata, serverCallHandler)
    }
}