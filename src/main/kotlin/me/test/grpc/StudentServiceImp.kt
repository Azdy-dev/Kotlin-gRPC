package me.test.grpc

import io.grpc.stub.StreamObserver
import me.test.grpc.student.StudentRequest
import me.test.grpc.student.StudentResponse
import me.test.grpc.student.StudentServiceGrpc.StudentServiceImplBase
import mu.KotlinLogging

class StudentServiceImp : StudentServiceImplBase() {

	companion object {
		private val  logger =   KotlinLogging.logger("grpc")
	}

	override fun getStudent(
		request: StudentRequest?,
		responseObserver: StreamObserver<StudentResponse>?
	) {
		logger.info("server received {}", request)
		val response =StudentResponse.newBuilder()
			.setId(request?.id!!)
			.setAge(30)
			.setName("tester")
			.build()
		logger.info("server responded {}", response)
		responseObserver?.onNext(response)
		responseObserver?.onCompleted()
	}

}