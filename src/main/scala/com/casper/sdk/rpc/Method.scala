package com.casper.sdk.rpc

/**
 * Enum with Capser netowrk RPC availaible  methods
 */

enum Method(val name: String) {
  case CHAIN_GET_BLOCK extends Method("chain_get_block")
  case INFO_GET_PEERS extends Method("info_get_peers")
  case STATE_ROOT_HASH extends Method("chain_get_state_root_hash")
  case INFO_GET_STATUS extends Method("info_get_status")
  case CHAIN_GET_BLOCK_TRANSFERTS extends Method("chain_get_block_transfers")
  case INFO_GET_DEPLOY extends Method("info_get_deploy")
  case STATE_GET_AUCTION_INFO extends Method("state_get_auction_info")
  case CHAIN_GET_ERA_INFO_BY_SWITCH_BLOCK extends Method("chain_get_era_info_by_switch_block")
}
