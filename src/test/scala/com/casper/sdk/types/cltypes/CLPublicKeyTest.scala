package com.casper.sdk.types.cltypes

import com.casper.sdk.util.HexUtils
import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class CLPublicKeyTest extends AnyFunSuite {
  val hexED25519 = "01d9bf2148748a85c89da5aad8ee0b0fc2d105fd39d41a4c796536354f0ae2900c"
  val keyED25519 = new CLPublicKey(hexED25519)

  val hexSECP256K1 = "0203e7d5b66b2fd0f66fb0efcceecb673b3762595b30ae1cac48ae8f09d34c952ee4"
  val keyESECP256K1 = new CLPublicKey(hexSECP256K1)


  val ed25519Pem = Source.fromURL(getClass.getResource("/crypto/ED25519_public_key.pem")) .mkString
  val secp256K1Pem = Source.fromURL(getClass.getResource("/crypto/SECP256K1_public_key.pem")).mkString

  test("Test CLPublicKey KeyAlgorithm = ED25519") {
    assert(keyED25519.keyAlgorithm== KeyAlgorithm.ED25519)
  }

  test("Test  ED25519 CLPublicKey  decode ") {
    assert(HexUtils.toHex(keyED25519.bytes).toLowerCase== "d9bf2148748a85c89da5aad8ee0b0fc2d105fd39d41a4c796536354f0ae2900c".toLowerCase)
  }

  test("Test ED25519 CLPublicKey formatAsHexAccount   ") {
    assert(keyED25519.formatAsHexAccount.toLowerCase == hexED25519.toLowerCase)
  }


  /**/

  test("Test CLPublicKey KeyAlgorithm = SECP256K1") {
    assert(keyESECP256K1.keyAlgorithm== KeyAlgorithm.SECP256K1)
  }

  test("Test SECP256K1 CLPublicKey  decode ") {
    assert(HexUtils.toHex(keyESECP256K1.bytes).toLowerCase== "03e7d5b66b2fd0f66fb0efcceecb673b3762595b30ae1cac48ae8f09d34c952ee4".toLowerCase)
  }

  test("Test SECP256K1 CLPublicKey formatAsHexAccount   ") {
    assert(keyESECP256K1.formatAsHexAccount.toLowerCase == hexSECP256K1.toLowerCase)
  }


/**/


  test("Test ED25519 CLPublicKey toPem String   ") {
   //  assert( keyED25519.toPemString().toLowerCase == ed25519Pem.toLowerCase)
  }

  test("Test SECP256K1 CLPublicKey toPem String   ") {
    assert( keyESECP256K1.toPemString().toLowerCase == secp256K1Pem.toLowerCase)
  }


  test("Test ED25519 CLPublicKey loadFromPem    ") {
    assert( CLPublicKey.fromPemFile(getClass.getResource("/crypto/ED25519_public_key.pem").getPath).formatAsHexAccount.toLowerCase == hexED25519.toLowerCase)
  }


  test("Test SECP256K1 CLPublicKey loadFromPem    ") {
    assert( CLPublicKey.fromPemFile( getClass.getResource("/crypto/SECP256K1_public_key.pem").getPath).formatAsHexAccount.toLowerCase == hexSECP256K1.toLowerCase)
  }


  test("Test new CLPublicKey with a non valid hex string  , throws IllegalArgumentException") {
    val caught:  IllegalArgumentException = intercept[IllegalArgumentException] {
      new CLPublicKey("9cfggg77ft07c211e44068D5dCc2cC28A67Cb582C3e239E83Bb0c3d06555f0363")
    }
    assert(caught.getMessage == "Unable to decode: 9cfggg77ft07c211e44068D5dCc2cC28A67Cb582C3e239E83Bb0c3d06555f0363")
  }

}
