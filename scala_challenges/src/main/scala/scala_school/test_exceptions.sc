object TestWorksheet {

  try {
    remoteCalculatorService.add(1, 2)
  } catch {
    case e: ServerIsDownException =>
      log.error(e, "the remote calculator service is unavailable. should have kept your trusty HP.")
      0
  } finally {
    remoteCalculatorService.close()
  }
}

object remoteCalculatorService {
  def close(): Unit = add(1, 2)

  def add(i: Int, i1: Int) = i + i1
}

trait ServerIsDownException

object log {
  def error(throwable: Throwable with ServerIsDownException, s: String) = 0
}
