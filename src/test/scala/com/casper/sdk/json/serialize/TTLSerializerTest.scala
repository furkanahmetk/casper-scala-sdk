package com.casper.sdk.json.serialize

import com.casper.sdk.crypto.hash.Hash
import com.casper.sdk.types.cltypes.CLPublicKey
import com.casper.sdk.util.CirceConverter
import org.scalatest.funsuite.AnyFunSuite
class TTLSerializerTest extends AnyFunSuite {

  test("Serialize CLPublicKey") {
    val json = """"7d96b9a63abcb61c870a4f55187a0a7ac24096bdb5fc585c12a686a4d892009e""""
    val pubkey =  CLPublicKey("017d96b9A63ABCB61C870a4f55187A0a7AC24096Bdb5Fc585c12a686a4D892009e").get
    val hash = new Hash(pubkey.bytes)//.get.bytes)
    info("new Hash( CLPublicKey(\"017d96b9A63ABCB61C870a4f55187A0a7AC24096Bdb5Fc585c12a686a4D892009e\")) json serialization =  " + json )
    assert(CirceConverter.toJson(hash) .get== json)
  }

}
